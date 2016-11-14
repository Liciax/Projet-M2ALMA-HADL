package m2.configuration.interfaces;

import java.util.List;

import m2.configuration.interfaces.port.Port;
import m2.configuration.interfaces.service.Service;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite InterfaceAPort represente une interface contenant des ports.
 */
public abstract class InterfaceAPort extends Interface {

	protected List<Port> ports;
	protected List<Service> services;

	/**
	 * Constructeur de InterfaceAPort
	 */
	public InterfaceAPort() {
		super();
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
	}

	/**
	 * Methode permettant de retrouver un point de connexion de l'interface
	 * @param nom un nom de point de connexion (port)
	 * @return pointConnexion le point de connexion correspondant sinon null
	 */
	public PointConnexion getPoint(String nom) {
		for (Port port : ports) {
			if (port.getNom().equals(nom)) {
				return port;
			}
		}
		return null;
	}

	/**
	 * Accesseur la liste des ports
	 * @return ports la liste des ports
	 */
	public List<Port> getPorts() {
		return ports;
	}

	/**
	 * Accesseur la liste des services
	 * @return services la liste des services
	 */
	public List<Service> getServices() {
		return services;
	}

}
