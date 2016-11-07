package m1.configuration.ComposantsSimples;

import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.port.Port;

public class Client extends ComposantSimple{

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public Client(ObserveurDeTransit obs) {
		super();
		this.entree = new InterfaceAPortConcret();
		this.sortie = new InterfaceAPortConcret();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeClient"));
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeClientBinding"));
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("SortieClient", obs));
	}
	
//	public void prepare(String commandToSend) {
//		LOGGER.info("Nous allons envoyer la commande " + commandToSend);
//		this.getSortie().getPoint("SortieClient").setVal(commandToSend);
////		this.lancer("EntreeClient");
//	}
	
	public void lancer(String p){
		LOGGER.info("Client : signal de la configuration reçu: le port " + p + " viens de recevoir un message qu'il faut traiter");
		String command;
		switch (p) {
		case "EntreeClient" :
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Le client a recu la commande " + command);
//			LOGGER.info("Client : la commande '" +command+ "' est arrivee dans le port EntreeClient du client, elle doit donc etre traitee et envoye vers le port SortieClient" );
//			this.getSortie().getPoint("SortieClient").setVal(command);
			break;
		case "EntreeClientBinding" :
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Le client a recu la commande " + command + "de l'exterieure");
//			LOGGER.info("Client : la commande '" +command+ "' est arrivee dans le port EntreeClient du client, elle doit donc etre traitee et envoye vers le port SortieClient" );
			this.getSortie().getPoint("SortieClient").setVal(command);
			break;
		default:
			LOGGER.info("lancer not implemented for this port of the Client");
			break;
		}
	}
}
