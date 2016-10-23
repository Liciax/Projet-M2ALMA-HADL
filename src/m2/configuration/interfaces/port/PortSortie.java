package m2.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;

public abstract class PortSortie extends Port {

	private ObserveurdeTransit obs;
	
	public PortSortie(String nom, ObserveurdeTransit o) {
		super(nom);
		this.obs = o;
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
