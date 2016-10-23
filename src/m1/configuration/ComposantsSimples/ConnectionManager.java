package m1.configuration.ComposantsSimples;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;

public class ConnectionManager extends ComposantSimple {

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
	
	public void lancer(String p){
		switch (p) {
		case "Receive_ExternalSocket" : 
			String command = this.getEntree().getPoint(p).getVal();
			System.out.println("Serveur : la commande '" +command+ "' est arrivee dans le port EntreeServeur du serveur, elle doit donc etre traitee et envoye vers le port SortieServeur" );
			this.getSortie().getPoint("SortieServeurBinding").setVal(command);
			break;
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
