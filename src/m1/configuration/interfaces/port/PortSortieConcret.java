package m1.configuration.interfaces.port;

import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m2.configuration.interfaces.port.PortSortie;

public class PortSortieConcret extends PortSortie {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public PortSortieConcret(String nom, ObserveurDeTransit o) {
		super(nom, o);
	}
	
	public void setVal(String val) {
		LOGGER.info("PortSortie : ecriture dans le port " + nom + " de la commande '" + val + "', delegation de la suite a la configuration " +System.getProperty("line.separator"));
		this.val = val;
		notifierEnvoi();
	}
}
