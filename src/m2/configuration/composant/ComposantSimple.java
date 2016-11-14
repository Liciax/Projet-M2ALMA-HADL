package m2.configuration.composant;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceAPort;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite ComposantSimple represente un composant simple du metamodele qui contient une interface entree, une interface sortie,
 * des proprietes et des contraintes techniques. 
 */
public abstract class ComposantSimple implements ComposantAbstrait {

	protected List<ContrainteTechnique> ct;
	protected List<Propriete> proprietes;
	protected InterfaceAPort entree;
	protected InterfaceAPort sortie;
	protected static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); //permet gestion des affichages consoles

	/**
	 * Constructeur de ComposantSimple, cree les listes.
	 */
	public ComposantSimple() {
		ct = new ArrayList<>();
		proprietes = new ArrayList<>();
	}
	
	/**
	 * Methode lancer non implemente dans composant simple.
	 * 
	 * @param p une simple string
	 */
	public void lancer(String p) {
		LOGGER.severe("lancer not implemented for ComposantSimple");
	}

	/**
	 * Accesseur de l'interface d'entree du composant simple compose de port.
	 * 
	 * @return l'interface d'entree du composant simple compose de port
	 */
	public InterfaceAPort getEntree() {
		return entree;
	}

	/**
	 * Mutateur de l'interface d'entree du composant simple compose de port.
	 * 
	 * @param entree l'interface d'entree du composant simple compose de port
	 */
	public void setEntree(InterfaceAPort entree) {
		this.entree = entree;
	}

	/**
	 * Accesseur de l'interface de sortie du composant simple compose de port.
	 * 
	 * @return l'interface de sortie du composant simple compose de port
	 */
	public InterfaceAPort getSortie() {
		return sortie;
	}

	/**
	 * Mutateur de l'interface de sortie du composant simple compose de port.
	 * 
	 * @param sortie l'interface de sortie du composant simple compose de port
	 */
	public void setSortie(InterfaceAPort sortie) {
		this.sortie = sortie;
	}

	/**
	 * Accesseur de la liste des contraintes techniques.
	 * 
	 * @return la liste des contraintes techniques
	 */
	public List<ContrainteTechnique> getCt() {
		return ct;
	}

	/**
	 * Accesseur de la liste des proprietes.
	 * 
	 * @return la liste des proprietes
	 */
	public List<Propriete> getProprietes() {
		return proprietes;
	}

}
