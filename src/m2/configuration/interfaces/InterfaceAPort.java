package m2.configuration.interfaces;

import java.util.ArrayList;
import m2.configuration.interfaces.port.*;
import m2.configuration.interfaces.service.Service;

public class InterfaceAPort extends Interface {

	private ArrayList<Port> ports;
	private ArrayList<Service> services;
	
	
	public InterfaceAPort() {
		super();
		this.ports = new ArrayList<Port>();
		this.services = new ArrayList<Service>();
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}
	
	public PointConnexion getPoint(String id){
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
