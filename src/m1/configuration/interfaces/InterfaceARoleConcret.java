package m1.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.InterfaceARole;
import m2.configuration.interfaces.port.Port;
import m2.configuration.interfaces.role.Role;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Implementation de la classe InterfaceARole pour contenir les roles
 *
 */
public class InterfaceARoleConcret extends InterfaceARole {

	public InterfaceARoleConcret() {
		super();
		this.roles = new ArrayList<Role>();
	}
}
