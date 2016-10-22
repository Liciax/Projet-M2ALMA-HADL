package m1.configuration.ComposantsSimples;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.port.Port;
import m2.configuration.interfaces.port.PortEntree;
import m2.configuration.interfaces.port.PortSortie;

public class Client extends ComposantSimple{

	public Client(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPort());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntree("Entr�eClient"));
		this.setSortie(new InterfaceAPort());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortie("SortieClient", obs));
	}
	
	public void prepare(String commandToSend) {
		this.getEntree().getPoint("Entr�eClient").setVal(commandToSend);
		this.lancer("Entr�eClient");
	}
	
	public void lancer(String p){
		System.out.println("Client : signal de la configuration re�u: le port " + p + " viens de recevoir un message qu'il faut traiter");
		switch (p) {
		case "Entr�eClient" :
			String command = this.getEntree().getPoint(p).getVal();
			System.out.println("Client : la commande '" +command+ "' est arriv�e dans le port Entr�eClient du client, elle doit donc etre trait�e et envoy� vers le port SortieClient" );
			this.getSortie().getPoint("SortieClient").setVal(command);
			break;
		default:
			System.out.println("lancer not implemented for this port of the Client");
			break;
		}
	}
}
