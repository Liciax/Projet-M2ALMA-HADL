package m2.configuration.interfaces.port;

import java.util.logging.Logger;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

public abstract class Port extends PointConnexion implements ComposantAbstrait {

	public Port(String nom) {
		super(nom);
	}
}
