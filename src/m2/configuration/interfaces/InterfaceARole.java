package m2.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.role.Role;

public abstract class InterfaceARole extends Interface {

	protected ArrayList<Role> roles;

	public InterfaceARole() {
		super();
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}

	public PointConnexion getPoint(String id) {
		for (Role role : roles) {
			if(role.getNom().equals(id)){
				return role;
			}
		}
		return null;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

}
