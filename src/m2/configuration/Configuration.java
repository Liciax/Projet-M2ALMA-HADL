package m2.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard La classe abstraite Configuration represente la
 *         configuration du metamodele, elle rassemble tous les composants et
 *         connecteurs et défini la façon dont ils sont reliés.
 */
public abstract class Configuration implements ComposantAbstrait {

	/* Permet la gestion des affichages consoles */
	protected static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	/*
	 * Associe les points de connexion de sortie d'un composant abstrait avec les
	 * points de connexion d'entree d'un composant abstrait correspondants
	 */
	protected HashMap<PointConnexion, PointConnexion> liaisons;
	/*
	 * Associe le port/role d'entree donne avec le composant abstrait qui le
	 * contient
	 */
	protected HashMap<PointConnexion, ComposantAbstrait> entrees;
	protected List<ComposantAbstrait> listeComposants;
	protected InterfaceAPort interfaceConfiguration;
	protected String id;

	/**
	 * Constructeur de Configuration, cree les listes et HashMap.
	 * 
	 * @param obs Observeur
	 */
	public Configuration(ObserveurDeTransit obs) {
		this.entrees = new HashMap<>();
		this.liaisons = new HashMap<>();
		this.listeComposants = new ArrayList<>();
	}

	/**
	 * Methode qui permet d'informer a un composant que un de ses points de
	 * connexion est rempli et qu'il doit donc effectuer une action.
	 * 
	 * @param p un point de connexion
	 */
	public void notifier(PointConnexion p) {
		LOGGER.info(System.getProperty("line.separator") + "************************************************************"
		    + System.getProperty("line.separator") + "Configuration : " + p.getNom()
		    + " souhaite envoyer un message. envoi du message au port correspondant: " + liaisons.get(p).getNom()
		    + " et signalement au ComposantAbstrait correspondant" + System.getProperty("line.separator")
		    + "************************************************************");
		liaisons.get(p).setVal(p.getVal());
		entrees.get(liaisons.get(p)).lancer(liaisons.get(p).getNom());
	}

	@Override
	public void lancer(String p) {
	}

	/**
	 * Accesseur de liaisons, la hashmap entre les points de connexion.
	 * 
	 * @return la hashmap des liaisons
	 */
	public Map<PointConnexion, PointConnexion> getLiaisons() {
		return liaisons;
	}

	/**
	 * Accesseur de entrees, la hashmap entre les points d'entrees et leurs
	 * composants.
	 * 
	 * @return la hashmap des entrees
	 */
	public Map<PointConnexion, ComposantAbstrait> getEntrees() {
		return entrees;
	}

	/**
	 * Accesseur de la liste des composants.
	 * 
	 * @return la liste des composants
	 */
	public List<ComposantAbstrait> getListeComposants() {
		return listeComposants;
	}

	/**
	 * Accesseur de l'interface de la configuration.
	 * 
	 * @return l'interface de la configuration
	 */
	public InterfaceAPort getInterfaceConfiguration() {
		return interfaceConfiguration;
	}

	/**
	 * Mutateur de l'interface contenant les ports de la configuration
	 * 
	 * @param interfConf l'interface de la configuration
	 */
	public void setInterfaceConfiguration(InterfaceAPort interfConf) {
		this.interfaceConfiguration = interfConf;
	}

	/**
	 * Accesseur de l'identifiant de la configuration
	 * 
	 * @return l'identifiant de la configuration
	 */
	public String getId() {
		return id;
	}

}
