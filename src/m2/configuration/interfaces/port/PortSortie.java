package m2.configuration.interfaces.port;

import m1.configuration.ObserveurDeTransit;

public abstract class PortSortie extends Port {

	private ObserveurDeTransit obs;
	
	public PortSortie(String nom, ObserveurDeTransit o) {
		super(nom);
		this.obs = o;
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
