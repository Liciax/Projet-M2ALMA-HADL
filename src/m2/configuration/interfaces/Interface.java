package m2.configuration.interfaces;

import m2.configuration.ComposantAbstrait;

public abstract class Interface implements ComposantAbstrait {

	public abstract PointConnexion getPoint(String nom);
}
