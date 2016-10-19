package m2.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.role.Role;

public class InterfaceARole extends Interface {

	private ArrayList<Role> roles;

	@Override
	public void lancer(PointConnexion p) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}
}
