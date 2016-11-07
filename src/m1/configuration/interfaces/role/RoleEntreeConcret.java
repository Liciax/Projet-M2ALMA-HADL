package m1.configuration.interfaces.role;

import java.util.logging.Logger;

import m2.configuration.interfaces.role.RoleEntree;

public class RoleEntreeConcret extends RoleEntree {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public RoleEntreeConcret(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public void setVal(String val) {
		System.out.println("");
		LOGGER.info("RoleEntree : ecriture dans le port " + nom + " de la commande '" + val + "'");
		this.val = val;
	}
}
