package m1.configuration.ComposantsSimples;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;

public class SecurityManager extends ComposantSimple {

	public SecurityManager(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_SecurityAnthPort"));//recevoir info du connectionManager
		this.getEntree().getPorts().add(new PortEntreeConcret("Receive_ConnexionQueryPort"));//recevoir reponse de la DB
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("Send_SecurityAnthPort", obs));//envoyer la reponse de la DB au connectionManager
		this.getSortie().getPorts().add(new PortSortieConcret("Send_ConnexionQueryPort", obs));//envoyer une demande de verification de la connection a la DB
	}
	
	public void lancer(String p){
		String command;
		switch (p) {
			
		case "Receive_SecurityAnthPort" : 
			command = this.getEntree().getPoint(p).getVal();
			System.out.println("SecurityManager : les identifiants de connexion '" +command+ "' sont arrivés dans le port Receive_SecurityAnthPort, transfert vers la DB pour verifier qu'ils sont valides" );
			this.getSortie().getPoint("Send_ConnexionQueryPort").setVal(command);
			break;
			
		case "Receive_ConnexionQueryPort" : 
			command = this.getEntree().getPoint(p).getVal();
			System.out.println("ConnectionManager : la reponse '" +command+ "' est arrivee de la DB dans le port Receive_ConnexionQueryPort, elle doit donc etre envoyee vers le ConnectionManager" );
			this.getSortie().getPoint("Send_SecurityAnthPort").setVal(command);
			break;
			
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
