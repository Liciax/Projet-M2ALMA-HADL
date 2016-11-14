package m2.configuration.interfaces;

import java.util.logging.Logger;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite PointConnexion represente un point de connexion quelconque qui peut etre un port ou un role
 */
public abstract class PointConnexion {

	protected String nom;
	protected String val;

	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); //permet gestion des affichages consoles
	
	/**
	 * Constructeur de PointConnexion
	 */
	public PointConnexion(String nom) {
		super();
		this.nom = nom;
		this.val = null;
	}

	/**
	 * Accesseur du nom du point de connexion
	 * @return nom le nom du point de connexion
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Mutateur du nom du point de connexion
	 * @param id le nom du point de connexion
	 */
	public void setNom(String id) {
		this.nom = id;
	}

	/**
	 * Accesseur de la valeur du point de connexion
	 * @return val la valeur du point de connexion
	 */
	public String getVal() {
		return val;
	}

	/**
	 * Mutateur de la valeur du point de connexion
	 * @param val la valeur du point de connexion
	 */
	public void setVal(String val) {
		this.val = val;
	}

}
