package m2.configuration.interfaces.service;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

public abstract class Service extends PointConnexion implements ComposantAbstrait {

	public Service(String nom, String val) {
		super(nom, val);
	}
}
