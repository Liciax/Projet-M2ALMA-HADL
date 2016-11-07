package m1.configuration.ComposantsSimples;

import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.port.Port;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe Client implemente ComposantSimple et possede 2 interfaces : une d'entree et une de sortie. 
 * Elle represente un Client qui peut se connecter et requeter sur une base de donnee.
 */
public class Client extends ComposantSimple{

	/**
	 * Constructeur de Client
	 * @param obs l'observeur qui va prevenir la configuration en cas de fin de traitement
	 */
	public Client(ObserveurDeTransit obs) {
		super();
		this.entree = new InterfaceAPortConcret();
		this.sortie = new InterfaceAPortConcret();
		
		this.setEntree(new InterfaceAPortConcret());
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeClient"));
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeClientBinding"));
		
		this.setSortie(new InterfaceAPortConcret());
		this.getSortie().getPorts().add(new PortSortieConcret("SortieClient", obs));
	}
	
	/**
	 * see also {@link m2.configuration.composant.ComposantSimple#lancer(String) lancer}
	 */
	public void lancer(String p){
		LOGGER.info("Client : signal de la configuration reçu: le port " + p + " viens de recevoir un message qu'il faut traiter");
		String command;
		switch (p) {
		case "EntreeClient" :
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Le client a recu la reponse '" + command + "'");
			break;
		case "EntreeClientBinding" :
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Le client a recu la commande '" + command + "' de l'exterieure");
			this.getSortie().getPoint("SortieClient").setVal(command);
			break;
		default:
			LOGGER.info("lancer not implemented for this port of the Client");
			break;
		}
	}
}
