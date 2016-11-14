package m2.configuration.connecteur;

import java.util.logging.Logger;

import m2.configuration.interfaces.PointConnexion;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard La classe abstraite Glue represente la glue du
 *         metamodele, elle permet de relier les roles qui interagissent entre
 *         eux.
 */
public abstract class Glue {

	// permet la gestion des affichages consoles
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Methode permettant de traduire les donnee de p pour etre lisible par le composant suivant
	 * @param p un point de connexion
	 * @return la valeur contenu dans le role
	 */
	public abstract String traduit(PointConnexion p);

}