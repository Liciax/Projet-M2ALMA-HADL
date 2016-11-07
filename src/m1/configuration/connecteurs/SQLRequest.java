package m1.configuration.connecteurs;

import java.util.logging.Logger;

import m1.configuration.connecteurs.glues.GlueSQLRequest;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;

public class SQLRequest extends Connecteur {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public SQLRequest(ObserveurdeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueSQLRequest(), new InterfaceARoleConcret(), new InterfaceARoleConcret());
		
		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerConnec"));//caller, requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerDB"));//caller, requis
		
		this.getTo().getRoles().add(new RoleSortieConcret("CalledConnec",obs));//called, fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CalledDB",obs));//called, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "CallerConnec" :
			LOGGER.info("SQLRequest : la commande '" +result+ "' est arrive dans le role CalledConnec du SQLRequest, elle doit donc etre traitee et envoye vers le port CallerDB" );
			this.getTo().getPoint("CalledDB").setVal(result);
			break;

		case "CallerDB" :
			LOGGER.info("SQLRequest : la commande '" +result+ "' est arrive dans le role CalledDB du SQLRequest, elle doit donc etre traitee et envoye vers le role CallerConnec" );
			this.getTo().getPoint("CalledConnec").setVal(result);
			break;
			
		default:
			LOGGER.info("lancer not implemented for Connecteur");
			break;
		}
	}
}
