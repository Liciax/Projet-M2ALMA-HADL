package m1.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;

public class PortSortieConcret extends PortSortie {

	public PortSortieConcret(String nom, String val, ObserveurdeTransit o) {
		super(nom, val, o);
		getObs() = o;
		// TODO Auto-generated constructor stub
	}
}
