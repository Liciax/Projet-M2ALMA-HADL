package m2.configuration.interfaces;

import java.util.ArrayList;

import m2.configuration.interfaces.port.Port;
import m2.configuration.interfaces.service.Service;

public abstract class InterfaceAPort extends Interface {

	protected ArrayList<Port> ports;
	protected ArrayList<Service> services;

	public InterfaceAPort() {
		super();
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}

	public PointConnexion getPoint(String id) {
		for (Port port : ports) {
			if(port.getId().equals(id)){
				return port;
			}
		}
		return null;
	}

	public ArrayList<Port> getPorts() {
		return ports;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

}