package m2.configuration.interfaces;

import m2.configuration.ComposantAbstrait;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite Interface represente une interface quelconque du metamodele.
 */
public abstract class Interface implements ComposantAbstrait {

	/**
	 * 
	 * @param nom un nom de point de connexion (port ou role)
	 * @return pointConnexion le point de connexion correspondant sinon null
	 */
	public abstract PointConnexion getPoint(String nom);
}
