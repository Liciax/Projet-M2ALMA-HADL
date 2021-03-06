package m1.configuration.ComposantsSimples;

import java.util.HashMap;
import java.util.Map;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.composant.ComposantSimple;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * La classe Database implemente ComposantSimple et possede 2 interfaces : une d'entree et une de sortie. 
 * Elle est chargee de faire le lien vers la Database concrete et d'effectuer les requetes. 
 * Elle ne peut etre utilisé par 2 Client en simultanée.
 */
public class Database extends ComposantSimple {

	private boolean occupe = false;// represente si la base de donnee est occupe ou non
	private Map<String, String[]> dBConcrete;// un mock d'une vraie base de donnee

	/**
	 * Constructeur de Database
	 * 
	 * @param obs l'observeur qui va prevenir la configuration en cas de fin de
	 *          traitement
	 */
	public Database(ObserveurDeTransit obs) {
		super();
		this.entree = new InterfaceAPortConcret();
		this.sortie = new InterfaceAPortConcret();
		this.setEntree(new InterfaceAPortConcret());
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityManagementPort"));// recevoir
		                                                                                         // demande
		                                                                                         // de
		                                                                                         // verification
		                                                                                         // d'identifiants
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_QueryIntPort"));// recevoir
		                                                                               // Query
		this.setSortie(new InterfaceAPortConcret());
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityManagementPort", obs));// envoyer
		                                                                                           // si
		                                                                                           // les
		                                                                                           // identifiants
		                                                                                           // sont
		                                                                                           // dans
		                                                                                           // la
		                                                                                           // DB
		this.getSortie().getPorts().add(new PortSortieConcret("Send_QueryIntPort", obs));// envoyer
		                                                                                 // reponse
		                                                                                 // Query

		this.dBConcrete = new HashMap<>();
		String[] tab = { "Poireau", "Carotte", "Aubergine" };
		this.dBConcrete.put("Bob", tab);
	}

	/**
	 * methode qui donne l'etat de la base
	 * 
	 * @param token
	 * @return l'etat de la base
	 */
	public String ReponseSecurite(String token) {
		if (occupe) {
			return "false";
		}
		return "true";
	}

	/**
	 * methode qui effectue la Query query sur la base et renvoie le resultat
	 * 
	 * @param query la query a executer
	 * @return la reponse
	 */
	public String ReponseQuery(String query) {
		occupe = true;
		StringBuilder sb = new StringBuilder();
		for (String s : this.dBConcrete.get("Bob")) {
			sb.append(s + ";");
		}
		return sb.toString();// Mock de la connexion vers une vraie DB avec de
		                     // vraies queries
	}

	/* (non-Javadoc)
	 * @see m2.configuration.composant.ComposantSimple#lancer(java.lang.String)
	 */
	public void lancer(String p) {
		String reponse;
		String command;
		switch (p) {

		case "Receive_SecurityManagementPort":
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Database : une demande de verification de l'etat est venu du SecurityManager");
			reponse = ReponseSecurite(command);
			this.getSortie().getPoint("Send_SecurityManagementPort").setVal(reponse);
			break;

		case "Receive_QueryIntPort":
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Database : la Query '" + command + "' est arrivee dans le port Receive_QueryIntPort, execution...");
			reponse = ReponseQuery(command);
			this.getSortie().getPoint("Send_QueryIntPort").setVal(reponse);
			break;

		default:
			LOGGER.severe("lancer not implemented for Serveur");
			break;
		}
	}
}
