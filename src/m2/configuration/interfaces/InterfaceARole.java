package m2.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.port.Port;
import m2.configuration.interfaces.role.Role;

public class InterfaceARole extends Interface {

	private ArrayList<Role> roles;

	
	public InterfaceARole() {
		super();
		this.roles = new ArrayList<Role>();
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}
	
	public PointConnexion getPoint(String id){
		for (Role role : roles) {
			if(role.getId().equals(id)){
				return role;
			}
		}
		return null;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}
}
