package m1.configuration.ComposantsSimples;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.composant.ComposantSimple;

public class SecurityManager extends ComposantSimple {

	private List<String> authorizedPasswords;
	
	public SecurityManager(ObserveurDeTransit obs) {
		super();
		this.entree = new InterfaceAPortConcret();
		this.sortie = new InterfaceAPortConcret();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityAnthPort"));//recevoir info du connectionManager
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_ConnexionQueryPort"));//recevoir reponse de la DB
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityAnthPort", obs));//envoyer la reponse de la DB au connectionManager
		this.getSortie().getPorts().add(new PortSortieConcret("Send_ConnexionQueryPort", obs));//envoyer une demande de verification de la connection a la DB
		this.authorizedPasswords = new ArrayList<String>();
		authorizedPasswords.add("ccadd99b16cd3d200c22d6db45d8b6630ef3d936767127347ec8a76ab992c2ea");
	}
	
	public void lancer(String p){
		String command;
		switch (p) {
			
		case "Receive_SecurityAnthPort" : 
			command = this.getEntree().getPoint(p).getVal();
			if(authorizedPasswords.contains(command)) {//autorisé, verification de l'etat de la Base de données
				LOGGER.info("SecurityManager : les identifiants de connexion '" +command+ "' sont valides, verification de l'etat de la base de données" );
				this.getSortie().getPoint("Send_ConnexionQueryPort").setVal("askIfFree");
			} else {
				LOGGER.info("acces refusé");
				this.getSortie().getPoint("Send_SecurityAnthPort").setVal("false");
			}
			
			break;
			
		case "Receive_ConnexionQueryPort" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("SecurityManager : la reponse '" +command+ "' est arrivee de la DB dans le port Receive_ConnexionQueryPort, elle doit donc etre envoyee vers le ConnectionManager" );
			this.getSortie().getPoint("Send_SecurityAnthPort").setVal(command);
			break;
			
		default:
			LOGGER.info("lancer not implemented for Serveur");
			break;
		}
	}
}
