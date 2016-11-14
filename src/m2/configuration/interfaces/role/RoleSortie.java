package m2.configuration.interfaces.role;

import m1.configuration.ObserveurDeTransit;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard La classe abstraite RoleSortie represente le concept
 *         de role en sortie du metamodele.
 */
public abstract class RoleSortie extends Role {

	private ObserveurDeTransit obs;

	/**
	 * Constructeur de role en sortie.
	 * 
	 * @param nom le nom du role en sortie
	 */
	public RoleSortie(String nom, ObserveurDeTransit obs) {
		super(nom);
		this.obs = obs;
	}

	public ObserveurDeTransit getObs() {
		return obs;
	}

	public void setObs(ObserveurDeTransit obs) {
		this.obs = obs;
	}

	public void notifierEnvoi() {
		obs.notifier(this);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub

	}

}