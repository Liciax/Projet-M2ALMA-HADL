package m1.configuration.connecteurs;

import m1.configuration.connecteurs.glues.GlueClearanceRequest;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;

public class ClearanceRequest extends Connecteur {

	public ClearanceRequest(ObserveurdeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueClearanceRequest(), new InterfaceARoleConcret(), new InterfaceARoleConcret());
		
		this.getFrom().getRoles().add(new RoleEntreeConcret("CalledConnec"));//called, requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CalledSecu"));//called, requis
		
		this.getTo().getRoles().add(new RoleSortieConcret("CallerConnec",obs));//caller, fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CallerSecu",obs));//caller, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "CalledConnec" :
			System.out.println("ClearanceRequest : la commande '" +p+ "' est arrive dans le role CalledConnec du ClearanceRequest, elle doit donc etre traitee et envoye vers le port CallerSecu" );
			this.getTo().getPoint("CallerSecu").setVal(result);
			break;

		case "CalledSecu" :
			System.out.println("ClearanceRequest : la commande '" +p+ "' est arrive dans le role CalledSecu du ClearanceRequest, elle doit donc etre traitee et envoye vers le port CallerConnec" );
			this.getTo().getPoint("CallerConnec").setVal(result);
			break;
			
		default:
			System.out.println("lancer not implemented for Connecteur");
			break;
		}
	}
}
