package m1.configuration.interfaces.port;

import m1.configuration.ObserveurDeTransit;
import m2.configuration.interfaces.port.PortSortie;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Implementation de la classe PortSortie avec un observeur pour signaler l'envoi de donnees
 *
 */
public class PortSortieConcret extends PortSortie {

	public PortSortieConcret(String nom, ObserveurDeTransit o) {
		super(nom, o);
	}

	/* (non-Javadoc)
	 * @see m2.configuration.interfaces.PointConnexion#setVal(java.lang.String)
	 */
	public void setVal(String val) {
		LOGGER.info("PortSortie : ecriture dans le port " + nom + " de la commande '" + val
		    + "', delegation de la suite a la configuration " + System.getProperty("line.separator"));
		this.val = val;
		notifierEnvoi();
	}
}
