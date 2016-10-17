package m2.configuration.interfaces;

import java.util.ArrayList;
import m2.configuration.interfaces.port.*;
import m2.configuration.interfaces.service.Service;

public abstract class InterfaceAPort implements Interface {

	private ArrayList<Port> ports;
	private ArrayList<Service> services;
	
}
