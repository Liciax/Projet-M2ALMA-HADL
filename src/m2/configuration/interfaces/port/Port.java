package m2.configuration.interfaces.port;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite Port represente le concept de port du metamodele.
 */
public abstract class Port extends PointConnexion implements ComposantAbstrait {

	/**
	 * Constructeur de port.
	 * @param nom le nom du port
	 */
	public Port(String nom) {
		super(nom);
	}
}
