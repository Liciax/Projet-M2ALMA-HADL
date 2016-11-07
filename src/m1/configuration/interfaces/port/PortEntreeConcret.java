package m1.configuration.interfaces.port;

import java.util.logging.Logger;

import m2.configuration.interfaces.port.PortEntree;

public class PortEntreeConcret extends PortEntree {

	
	public PortEntreeConcret(String nom) {
		super(nom);
	}
	

	public void setVal(String val) {
		System.out.println("");
		LOGGER.info("PortEntree : ecriture dans le port " + nom + " de la commande '" + val + "'");
		this.val = val;
	}

}
