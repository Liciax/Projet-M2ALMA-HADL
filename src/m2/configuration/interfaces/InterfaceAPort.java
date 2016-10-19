package m2.configuration.interfaces;

import java.util.ArrayList;
import m2.configuration.interfaces.port.*;
import m2.configuration.interfaces.service.Service;

public class InterfaceAPort extends Interface {

	private ArrayList<Port> ports;
	private ArrayList<Service> services;
	
	@Override
	public void lancer(PointConnexion p) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Port> getPorts() {
		return ports;
	}

	public ArrayList<Service> getServices() {
		return services;
	}
	
	
	
}
