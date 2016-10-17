package m2.configuration;

import m2.configuration.interfaces.PointConnexion;

public class ObserveurdeTransit {
	
	private Configuration configObservant;

	public ObserveurdeTransit(Configuration configObservant) {
		super();
		this.configObservant = configObservant;
	}
	
	public void notifier(PointConnexion p) {
		configObservant.notifier(p);
	}

	public Configuration getConfigObservant() {
		return configObservant;
	}

	public void setConfigObservant(Configuration configObservant) {
		this.configObservant = configObservant;
	}

}
