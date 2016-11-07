package m2.configuration.interfaces;

import java.util.logging.Logger;

public abstract class PointConnexion {

	protected String nom;
	protected String val;
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	
	public PointConnexion(String nom) {
		super();
		this.nom = nom;
		this.val = null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String id) {
		this.nom = id;
	}
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	
}
