package m1.configuration;

import m2.configuration.Configuration;
import m2.configuration.interfaces.PointConnexion;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * 
 */
public class ObserveurDeTransit {
	
	private Configuration configObservant;

	/**
	 * Constructeur de ObserveurDeTransit
	 * @param configObservant Configuration 
	 */
	public ObserveurDeTransit(Configuration configObservant) {
		super();
		this.configObservant = configObservant;
	}
	
	/**
	 * Methode qui permet d'informer a un composant que un de ses points de connexion est rempli et qu'il doit donc
	 * effectuer une action.
	 * @param p un point de connexion 
	 */
	public void notifier(PointConnexion p) {
		configObservant.notifier(p);
	}

	/**
	 * Accesseur de la configuration observante.
	 * @return la configuration observante
	 */
	public Configuration getConfigObservant() {
		return configObservant;
	}

	/**
	 * Mutateur de la configuration observante
	 * @param configObservant la configuration observante
	 */
	public void setConfigObservant(Configuration configObservant) {
		this.configObservant = configObservant;
	}

}
