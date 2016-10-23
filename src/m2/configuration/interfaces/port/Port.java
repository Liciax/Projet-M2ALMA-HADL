package m2.configuration.interfaces.port;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

public abstract class Port extends PointConnexion implements ComposantAbstrait {

	public Port(String nom, String val) {
		super(nom, val);
	}
}
