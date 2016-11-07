package m2.configuration.connecteur;

import java.util.logging.Logger;

import m2.configuration.interfaces.PointConnexion;

public abstract class Glue {

	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public String traduit(PointConnexion p) {
		System.out.println("traduit not implemented");
		return "";
	}
}
