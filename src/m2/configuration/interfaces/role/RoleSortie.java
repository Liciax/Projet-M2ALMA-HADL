package m2.configuration.interfaces.role;

import m1.configuration.ObserveurDeTransit;

public abstract class RoleSortie extends Role {

	private ObserveurDeTransit obs;

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
