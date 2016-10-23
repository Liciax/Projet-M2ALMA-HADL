package m1.configuration.connecteurs;
import m1.configuration.connecteurs.glues.GlueSecurityQuery;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;


public class SecurityQuery extends Connecteur {
	
	public SecurityQuery(ObserveurdeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueSecurityQuery(), new InterfaceARoleConcret(), new InterfaceARoleConcret());
		
		this.getFrom().getRoles().add(new RoleEntreeConcret("CalledDB"));//caller, requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CalledSecu"));//caller, requis
		
		this.getTo().getRoles().add(new RoleSortieConcret("CallerDB",obs));//called, fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CallerSecu",obs));//called, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "CalledDB" :
			System.out.println("SecurityQuery : la commande '" +p+ "' est arrive dans le port CalledDB du SecurityQuery, elle doit donc etre traitee et envoye vers le port CallerSecu" );
			this.getTo().getPoint("CallerSecu").setVal(result);
			break;

		case "CalledSecu" :
			System.out.println("SecurityQuery : la commande '" +p+ "' est arrive dans le port CalledSecu du SecurityQuery, elle doit donc etre traitee et envoye vers le port CallerDB" );
			this.getTo().getPoint("CallerDB").setVal(result);
			break;
			
		default:
			System.out.println("lancer not implemented for Connecteur");
			break;
		}
	}
}
