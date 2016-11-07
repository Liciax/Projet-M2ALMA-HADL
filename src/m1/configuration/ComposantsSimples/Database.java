package m1.configuration.ComposantsSimples;

import java.util.logging.Logger;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;

public class Database extends ComposantSimple {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public Database(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityManagementPort"));//recevoir demande de verification d'identifiants
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_QueryIntPort"));//recevoir Query
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityManagementPort", obs));//envoyer si les identifiants sont dans la DB
		this.getSortie().getPorts().add(new PortSortieConcret("Send_QueryIntPort", obs));//envoyer reponse Query
	}
	
	public String ReponseSecurite(String identifiants) {
		return "true";//on considere que toute demande de connexion est acceptee
	}
	
	public String ReponseQuery(String identifiants) {
		return "Resultat de la query";//Mock de la connexion vers une vraie DB avec de vraies queries
	}
	
	public void lancer(String p){
		String command;
		String reponse;
		switch (p) {
			
		case "Receive_SecurityManagementPort" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Database : les identifiants de connexion '" +command+ "' sont arrives dans le port Receive_SecurityManagementPort, verification de leur validite..." );
			//Check DB et retour "vrai" ou "faux"
			reponse = ReponseSecurite(command);
			this.getSortie().getPoint("Send_SecurityManagementPort").setVal(reponse);
			break;
			
		case "Receive_QueryIntPort" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Database : la Query '" +command+ "' est arrivee dans le port Receive_QueryIntPort, execution..." );
			reponse = ReponseQuery(command);
			this.getSortie().getPoint("Send_QueryIntPort").setVal(reponse);
			break;
			
		default:
			LOGGER.info("lancer not implemented for Serveur");
			break;
		}
	}
}
