package m1.configuration.interfaces.port;

import java.util.logging.Logger;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.PortSortie;

public class PortSortieConcret extends PortSortie {

	
	public PortSortieConcret(String nom, ObserveurdeTransit o) {
		super(nom, o);
	}
	
	public void setVal(String val) {
		LOGGER.info("PortSortie : ecriture dans le port " + nom + " de la commande '" + val + "', delegation de la suite a la configuration " +System.getProperty("line.separator"));
		this.val = val;
		notifierEnvoi();
	}
}
