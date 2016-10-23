package m1.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.InterfaceARole;
import m2.configuration.interfaces.port.Port;
import m2.configuration.interfaces.role.Role;

public class InterfaceARoleConcret extends InterfaceARole {

	public InterfaceARoleConcret() {
		super();
		this.roles = new ArrayList<Role>();
	}
}
