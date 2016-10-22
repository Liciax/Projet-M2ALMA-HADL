package m2.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;

public class PortSortie extends Port {

	public PortSortie(String nom, ObserveurdeTransit o) {
		super(nom);
		this.obs = o;
		// TODO Auto-generated constructor stub
	}

	private ObserveurdeTransit obs;
	
	public void notifierEnvoi() {
		obs.notifier(this);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}
}
