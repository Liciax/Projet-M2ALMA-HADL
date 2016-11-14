package m2.configuration.interfaces.service;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard La classe abstraite ServiceSortie represente le
 *         concept de service en sortie du metamodele.
 */
public abstract class ServiceSortie extends Service {

	/**
	 * Constructeur de service en sortie.
	 * 
	 * @param nom le nom du service en sortie
	 */
	public ServiceSortie(String nom) {
		super(nom);
	}

}