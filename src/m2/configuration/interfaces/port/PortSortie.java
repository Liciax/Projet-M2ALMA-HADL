package m2.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;

public abstract class PortSortie extends Port {

	private ObserveurdeTransit obs;
	
	public void notifierEnvoi() {
		obs.notifier(this);
	}
}
