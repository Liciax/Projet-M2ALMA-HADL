package m2.configuration.connecteur;

import java.util.logging.Logger;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceARole;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * 
 * La classe abstraite Connecteur represente un connecteur du metamodele qui a un type et qui contient une glue, 
 * une interface from et une interface to.
 */
public abstract class Connecteur implements ComposantAbstrait{
	
	protected final TypeConnecteur type;
	protected Glue glue;
	protected InterfaceARole from;
	protected InterfaceARole to;
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); //permet gestion des affichages consoles
	
	/**
	 * Constructeur de Connecteur
	 */
	public Connecteur(TypeConnecteur type, Glue glue, InterfaceARole from, InterfaceARole to) {
		super();
		this.type = type;
		this.glue = glue;
		this.from = from;
		this.to = to;
	}

	@Override
	public void lancer(String p){
		switch (p) {
		default:
			LOGGER.severe("lancer not implemented for Connecteur");
			break;
		}
	}

	/**
	 * Accesseur du type de connecteur
	 * @return type un enum representant le type du connecteur
	 */
	public TypeConnecteur getType() {
		return type;
	}

	/**
	 * Accesseur de la glue du connecteur
	 * @return glue la glue du connecteur
	 */
	public Glue getGlue() {
		return glue;
	}

	/**
	 * Mutateur de la glue du connecteur
	 * @param glue la glue du connecteur
	 */
	public void setGlue(Glue glue) {
		this.glue = glue;
	}

	/**
	 * Accesseur de l'interface from du connecteur
	 * @return from l'interface from du connecteur
	 */
	public InterfaceARole getFrom() {
		return from;
	}

	/**
	 * Mutateur de l'interface from du connecteur
	 * @param from l'interface from du connecteur
	 */
	public void setFrom(InterfaceARole from) {
		this.from = from;
	}

	/**
	 * Accesseur de l'interface to du connecteur
	 * @return to l'interface to du connecteur
	 */
	public InterfaceARole getTo() {
		return to;
	}

	/**
	 * Mutateur de l'interface to du connecteur
	 * @param to l'interface to du connecteur
	 */
	public void setTo(InterfaceARole to) {
		this.to = to;
	}

}
