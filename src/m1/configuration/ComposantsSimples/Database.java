package m1.configuration.ComposantsSimples;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;

public class Database extends ComposantSimple {

	public Database(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityManagementPort"));//recevoir demande de verification d'identifiants
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_QueryIntPort"));//recevoir Query
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityManagementPort", obs));//envoyer si les identifiants sont dans la DB
		this.getSortie().getPorts().add(new PortSortieConcret("Send_QueryIntPort", obs));//envoyer reponse Query
	}
	
	public void ReponseSecurité(String identifiants) {
		
	}
	
	public void lancer(String p){
		String command;
		String reponse;
		switch (p) {
			
		case "Receive_SecurityManagementPort" : 
			command = this.getEntree().getPoint(p).getVal();
			System.out.println("Database : les identifiants de connexion '" +command+ "' sont arrivés dans le port Receive_SecurityManagementPort, verification de leur validite..." );
			//Check DB et retour "vrai" ou "faux"
			reponse = "";// = fonction();
			this.getSortie().getPoint("Send_ConnexionQueryPort").setVal(reponse);
			break;
			
		case "Receive_QueryIntPort" : 
			command = this.getEntree().getPoint(p).getVal();
			System.out.println("Database : la Query '" +command+ "' est arrivee dans le port Receive_QueryIntPort, execution..." );
			reponse = "";// = fonction();
			this.getSortie().getPoint("Send_SecurityAnthPort").setVal(reponse);
			break;
			
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
