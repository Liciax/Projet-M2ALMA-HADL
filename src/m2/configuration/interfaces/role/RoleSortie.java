package m2.configuration.interfaces.role;

import m2.configuration.ObserveurdeTransit;

public abstract class RoleSortie extends Role {

	private ObserveurdeTransit obs;

	public RoleSortie(String nom, ObserveurdeTransit obs) {
		super(nom);
		this.obs = obs;
	}
	
	public ObserveurdeTransit getObs() {
		return obs;
	}

	public void setObs(ObserveurdeTransit obs) {
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
