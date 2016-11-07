package m2.configuration.interfaces.role;

import java.util.logging.Logger;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

public abstract class Role extends PointConnexion implements ComposantAbstrait {

	public Role(String nom) {
		super(nom);
	}
}
