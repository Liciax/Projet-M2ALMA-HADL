package m2.configuration;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard L'interface ComposantAbstrait permet d'avoir une
 *         généricité sur toutes les classes de notre architecture à composants.
 */
public interface ComposantAbstrait {

	/**
	 * Methode qui, lorsqu'elle est appelee, signifie qu'une information vient
	 * d'arriver dans un port d'entree.
	 * 
	 * @param p le port qui vient d'être rempli par
	 */
	public void lancer(String p);
}
