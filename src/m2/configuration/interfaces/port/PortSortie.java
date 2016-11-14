package m2.configuration.interfaces.port;

import m1.configuration.ObserveurDeTransit;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite PortSortie represente le concept de port de sortie du metamodele.
 */
public abstract class PortSortie extends Port {

	private ObserveurDeTransit obs;

	/**
	 * Constructeur de port de sortie.
	 * @param nom le nom du port de sortie
	 * @param o l'observeur
	 */
	public PortSortie(String nom, ObserveurDeTransit o) {
		super(nom);
		this.obs = o;
	}

	/**
	 * Getter de l'observeur
	 * @return obs l'observeur
	 */
	public ObserveurDeTransit getObs() {
		return obs;
	}
	
	/**
	 * Mutateur de l'observeur
	 * @param obs l'observeur
	 */
	public void setObs(ObserveurDeTransit obs) {
		this.obs = obs;
	}

	/**
	 * Methode qui notifie un envoi de donnée
	 */
	public void notifierEnvoi() {
		obs.notifier(this);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub

	}

}
