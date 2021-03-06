package m1.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.port.*;
import m2.configuration.interfaces.service.Service;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Implementation de la classe InterfaceAPort pour contenir les ports
 *
 */
public class InterfaceAPortConcret extends InterfaceAPort {

	public InterfaceAPortConcret() {
		super();
		this.ports = new ArrayList<Port>();
		this.services = new ArrayList<Service>();
	}

}
