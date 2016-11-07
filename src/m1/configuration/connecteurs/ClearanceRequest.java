package m1.configuration.connecteurs;

import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.connecteurs.glues.GlueClearanceRequest;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;

public class ClearanceRequest extends Connecteur {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public ClearanceRequest(ObserveurDeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueClearanceRequest(), new InterfaceARoleConcret(), new InterfaceARoleConcret());
		
		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerConnec"));//caller, requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerSecu"));//caller, requis
		
		this.getTo().getRoles().add(new RoleSortieConcret("CalledConnec",obs));//called, fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CalledSecu",obs));//called, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));

		switch (p) {
		case "CallerConnec" :
			LOGGER.info("ClearanceRequest : la commande '" +result+ "' est arrive dans le role CalledConnec du ClearanceRequest, elle doit donc etre traitee et envoye vers le port CallerSecu" );
			this.getTo().getPoint("CalledSecu").setVal(result);
			break;

		case "CallerSecu" :
			LOGGER.info("ClearanceRequest : la commande '" +result+ "' est arrive dans le role CalledSecu du ClearanceRequest, elle doit donc etre traitee et envoye vers le port CallerConnec" );
			this.getTo().getPoint("CalledConnec").setVal(result);
			break;
			
		default:
			LOGGER.info("lancer not implemented for Connecteur");
			break;
		}
	}
}
