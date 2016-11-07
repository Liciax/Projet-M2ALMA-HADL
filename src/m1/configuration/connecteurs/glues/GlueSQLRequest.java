package m1.configuration.connecteurs.glues;

import java.util.logging.Logger;

import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;

public class GlueSQLRequest extends Glue {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public String traduit(PointConnexion p) {
		LOGGER.info("GlueClearanceRequest : traduction par la glue");
		switch(p.getNom()) {//traitement peut etre different en fonction de la glue
		case "CallerConnec":
			return p.getVal();

		case "CallerDB":
			return p.getVal();
			
		default:
			return null;
		}
	}
}
