package m1.configuration.interfaces.role;

import m1.configuration.ObserveurDeTransit;
import m2.configuration.interfaces.role.RoleSortie;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Implementation de la classe RoleSortie avec un observeur pour signaler l'envoi de donnees
 *
 */
public class RoleSortieConcret extends RoleSortie {

	public RoleSortieConcret(String nom, ObserveurDeTransit obs) {
		super(nom, obs);
	}

	/* (non-Javadoc)
	 * @see m2.configuration.interfaces.PointConnexion#setVal(java.lang.String)
	 */
	public void setVal(String val) {
		LOGGER.info("RoleSortie : ecriture dans le role " + nom + "de la commande '" + val
		    + "', delegation de la suite a la configuration" + System.getProperty("line.separator"));
		this.val = val;
		this.notifierEnvoi();
	}

}
