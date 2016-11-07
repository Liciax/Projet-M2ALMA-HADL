package m1.configuration.interfaces.role;

import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m2.configuration.interfaces.role.RoleSortie;

public class RoleSortieConcret extends RoleSortie {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public RoleSortieConcret(String nom, ObserveurDeTransit obs) {
		super(nom, obs);
	}
	
	public void setVal(String val) {
		LOGGER.info("RoleSortie : ecriture dans le role " + nom + "de la commande '" + val + "', delegation de la suite a la configuration"+System.getProperty("line.separator"));
		this.val = val;
		this.notifierEnvoi();
	}

}
