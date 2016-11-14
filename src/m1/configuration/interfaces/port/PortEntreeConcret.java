package m1.configuration.interfaces.port;

import m2.configuration.interfaces.port.PortEntree;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * implementation de PortEntree
 *
 */
public class PortEntreeConcret extends PortEntree {

	public PortEntreeConcret(String nom) {
		super(nom);
	}

	/* (non-Javadoc)
	 * @see m2.configuration.interfaces.PointConnexion#setVal(java.lang.String)
	 */
	public void setVal(String val) {
		System.out.println("");
		LOGGER.info("PortEntree : ecriture dans le port " + nom + " de la commande '" + val + "'");
		this.val = val;
	}

}
