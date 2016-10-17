package m2.configuration;

import m2.configuration.interfaces.port.PortSortie;

public class ObserveurdeTransit {
	
	private Configuration configObservant;

	public ObserveurdeTransit(Configuration configObservant) {
		super();
		this.configObservant = configObservant;
	}
	
	public void notifier(PortSortie p) {
		configObservant.notifier(p);
	}

}
