package m2.configuration.interfaces.service;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite ServiceEntree represente le concept de service en entree du metamodele.
 */
public abstract class ServiceEntree extends Service {

	/**
	 * Constructeur de service en entree.
	 * @param nom le nom du service en entree
	 */
	public ServiceEntree(String nom) {
		super(nom);
	}
	
}