package m2.configuration.interfaces.role;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite Role represente le concept de role du metamodele.
 */
public abstract class Role extends PointConnexion implements ComposantAbstrait {
	
	/**
	 * Constructeur de role.
	 * @param nom le nom du role
	 */
	public Role(String nom) {
		super(nom);
	}
	
}