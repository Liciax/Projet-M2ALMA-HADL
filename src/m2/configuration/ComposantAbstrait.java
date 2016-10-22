package m2.configuration;

public interface ComposantAbstrait {

	/** methode qui, lorsqu'elle est appelee, signifie qu'une information viens d'arriver dans un port d'entree
	 * @param p le port qui viens d'etre remplis
	 */
	public void lancer(String p);
}
