package m1.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.PortSortie;

public class PortSortieConcret extends PortSortie {

	public PortSortieConcret(String nom, ObserveurdeTransit o) {
		super(nom);
		this.obs = o;
		// TODO Auto-generated constructor stub
	}
}
