package m2.configuration.interfaces.role;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

public abstract class Role extends PointConnexion implements ComposantAbstrait{

	public Role(String nom) {
		this.id = nom;
	}

	
}
