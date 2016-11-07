package m1.configuration.ComposantsSimples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.composant.ComposantSimple;

public class Database extends ComposantSimple {

	private boolean occupe = false;
	private Map<String, String[]> DBConcrete;
	public Database(ObserveurDeTransit obs) {
		super();
		this.entree = new InterfaceAPortConcret();
		this.sortie = new InterfaceAPortConcret();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityManagementPort"));//recevoir demande de verification d'identifiants
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_QueryIntPort"));//recevoir Query
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityManagementPort", obs));//envoyer si les identifiants sont dans la DB
		this.getSortie().getPorts().add(new PortSortieConcret("Send_QueryIntPort", obs));//envoyer reponse Query
		
		this.DBConcrete = new HashMap<String,String[]>();
		String[] tab = {"Poireau", "Carotte", "Aubergine"};
		this.DBConcrete.put("Bob", tab);
	}
	
	public String ReponseSecurite(String token) {
		if(occupe){
			return "false";
		}
		return "true";
	}
	
	public String ReponseQuery(String identifiants) {
		occupe = true;
		String rep = "";
		for (String s : this.DBConcrete.get("Bob")) {
			rep += s + ";";
		}
		return rep;//Mock de la connexion vers une vraie DB avec de vraies queries
	}
	
	public void lancer(String p){
		String command;
		String reponse;
		switch (p) {
			
		case "Receive_SecurityManagementPort" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Database : une demande de verification de l'etat est venu du SecurityManager" );
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
