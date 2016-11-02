package m1.configuration.ComposantsSimples;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.port.Port;

public class Client extends ComposantSimple{

	public Client(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeClient"));
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeClientBinding"));
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("SortieClient", obs));
	}
	
//	public void prepare(String commandToSend) {
//		System.out.println("Nous allons envoyer la commande " + commandToSend);
//		this.getSortie().getPoint("SortieClient").setVal(commandToSend);
////		this.lancer("EntreeClient");
//	}
	
	public void lancer(String p){
		System.out.println("Client : signal de la configuration reeu: le port " + p + " viens de recevoir un message qu'il faut traiter");
		String command;
		switch (p) {
		case "EntreeClient" :
			command = this.getEntree().getPoint(p).getVal();
			System.out.println("Le client a recu la commande " + command);
//			System.out.println("Client : la commande '" +command+ "' est arrivee dans le port EntreeClient du client, elle doit donc etre traitee et envoye vers le port SortieClient" );
//			this.getSortie().getPoint("SortieClient").setVal(command);
			break;
		case "EntreeClientBinding" :
			command = this.getEntree().getPoint(p).getVal();
			System.out.println("Le client a recu la commande " + command + "de l'exterieure");
//			System.out.println("Client : la commande '" +command+ "' est arrivee dans le port EntreeClient du client, elle doit donc etre traitee et envoye vers le port SortieClient" );
			this.getSortie().getPoint("SortieClient").setVal(command);
			break;
		default:
			System.out.println("lancer not implemented for this port of the Client");
			break;
		}
	}
}
