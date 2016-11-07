package m2.configuration.interfaces.service;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite Service represente le concept de service du metamodele.
 */
public abstract class Service extends PointConnexion implements ComposantAbstrait {
	
	/**
	 * Constructeur de Service.
	 * @param nom le nom du service
	 */
	public Service(String nom) {
		super(nom);
	}
	
}