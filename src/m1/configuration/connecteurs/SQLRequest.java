package m1.configuration.connecteurs;

import m1.configuration.connecteurs.glues.GlueSQLRequest;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;

public class SQLRequest extends Connecteur {
	
	public SQLRequest(ObserveurdeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueSQLRequest(), new InterfaceARoleConcret(), new InterfaceARoleConcret());
		
		this.getFrom().getRoles().add(new RoleEntreeConcret("CalledConnec"));//caller, requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CalledDB"));//caller, requis
		
		this.getTo().getRoles().add(new RoleSortieConcret("CallerConnec",obs));//called, fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CallerDB",obs));//called, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "CalledConnec" :
			System.out.println("SQLRequest : la commande '" +p+ "' est arrive dans le role CalledConnec du SQLRequest, elle doit donc etre traitee et envoye vers le port CallerDB" );
			this.getTo().getPoint("CallerDB").setVal(result);
			break;

		case "CalledDB" :
			System.out.println("SQLRequest : la commande '" +p+ "' est arrive dans le role CalledDB du SQLRequest, elle doit donc etre traitee et envoye vers le role CallerConnec" );
			this.getTo().getPoint("CallerConnec").setVal(result);
			break;
			
		default:
			System.out.println("lancer not implemented for Connecteur");
			break;
		}
	}
}