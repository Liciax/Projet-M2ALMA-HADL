package m1.configuration.interfaces.role;

import java.util.logging.Logger;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.role.RoleSortie;

public class RoleSortieConcret extends RoleSortie {

	
	public RoleSortieConcret(String nom, ObserveurdeTransit obs) {
		super(nom, obs);
	}
	
	public void setVal(String val) {
		LOGGER.info("RoleSortie : ecriture dans le role " + nom + "de la commande '" + val + "', delegation de la suite a la configuration"+System.getProperty("line.separator"));
		this.val = val;
		this.notifierEnvoi();
	}

}
