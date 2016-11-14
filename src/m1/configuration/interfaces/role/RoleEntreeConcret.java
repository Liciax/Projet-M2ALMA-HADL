package m1.configuration.interfaces.role;

import m2.configuration.interfaces.role.RoleEntree;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Implementation de la classe RoleEntree
 *
 */
public class RoleEntreeConcret extends RoleEntree {

	public RoleEntreeConcret(String nom) {
		super(nom);
	}

	/* (non-Javadoc)
	 * @see m2.configuration.interfaces.PointConnexion#setVal(java.lang.String)
	 */
	public void setVal(String val) {
		System.out.println("");
		LOGGER.info("RoleEntree : ecriture dans le port " + nom + " de la commande '" + val + "'");
		this.val = val;
	}
}
