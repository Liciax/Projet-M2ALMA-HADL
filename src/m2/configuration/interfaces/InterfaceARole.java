package m2.configuration.interfaces;


import java.util.List;

import m2.configuration.interfaces.role.Role;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite InterfaceARole represente une interface contenant des roles.
 */
public abstract class InterfaceARole extends Interface {

	protected List<Role> roles;

	/**
	 * Constructeur de InterfaceARole
	 */
	public InterfaceARole() {
		super();
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub

	}

	/**
	 * Methode permettant de retrouver un point de connexion de l'interface
	 * @param nom un nom de point de connexion (role)
	 * @return pointConnexion le point de connexion correspondant sinon null
	 */
	public PointConnexion getPoint(String nom) {
		for (Role role : roles) {
			if (role.getNom().equals(nom)) {
				return role;
			}
		}
		return null;
	}

	/**
	 * Accesseur la liste des roles
	 * @return roles la liste des roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

}
