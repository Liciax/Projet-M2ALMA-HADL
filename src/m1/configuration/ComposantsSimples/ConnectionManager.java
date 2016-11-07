package m1.configuration.ComposantsSimples;

import java.util.logging.Logger;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;

public class ConnectionManager extends ComposantSimple {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public ConnectionManager(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_ExternalSocket"));//recevoir info du Binding
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityCheck"));//recevoir reponse de connexion
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_DBQuery"));//recevoir reponce de la query
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("Send_ExternalSocket", obs));//envoyer le resultat au serveur
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityCheck", obs));//envoyer une demande pour verifier les identifiants
		this.getSortie().getPorts().add(new PortSortieConcret("Send_DBQuery", obs));//envoyer une requete
	}
	
	public void aiguillage(String message) {
		String type = message.split(":")[0];
		String value = message.split(":")[1];
		switch (type) {
		case "Connexion":
			this.getSortie().getPoint("Send_SecurityCheck").setVal(value);
			break;
			
		case "Query":
			this.getSortie().getPoint("Send_DBQuery").setVal(value);
			break;

		default:
			break;
		}
	}
	
	public void lancer(String p){
		String command;
		switch (p) {
		case "Receive_ExternalSocket" : 
			command = this.getEntree().getPoint(p).getVal();
			this.aiguillage(command);
			break;
			
		case "Receive_SecurityCheck" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("ConnectionManager : la reponse '" +command+ "' est arrivee dans le port Receive_SecurityCheck, elle doit donc etre envoyee vers le serveur" );
			this.getSortie().getPoint("Send_ExternalSocket").setVal(command);
			break;
			
		case "Receive_DBQuery" :
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("ConnectionManager : la reponse '" +command+ "' est arrivee dans le port Receive_DBQuery, elle doit donc etre envoyee vers le serveur" );
			this.getSortie().getPoint("Send_ExternalSocket").setVal(command);
			break;
			
		default:
			LOGGER.info("lancer not implemented for Serveur");
			break;
		}
	}
}
