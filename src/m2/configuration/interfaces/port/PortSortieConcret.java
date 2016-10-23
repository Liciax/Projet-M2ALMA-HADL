package m2.configuration.interfaces.port;

import m1.configuration.interfaces.port.PortSortie;
import m2.configuration.ObserveurdeTransit;

public class PortSortieConcret extends PortSortie {

	public PortSortieConcret(String nom, ObserveurdeTransit o) {
		super(nom);
		this.obs = o;
		// TODO Auto-generated constructor stub
	}
}
