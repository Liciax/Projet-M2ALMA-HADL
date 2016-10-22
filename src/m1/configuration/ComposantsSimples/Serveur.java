package m1.configuration.ComposantsSimples;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.port.PortEntree;
import m2.configuration.interfaces.port.PortSortie;

public class Serveur extends ComposantSimple{

	public Serveur(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPort());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntree("EntréeServeur"));
		this.setSortie(new InterfaceAPort());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortie("SortieServeur", obs));//pour retour vers le client
		this.getSortie().getPorts().add(new PortSortie("SortieServeurBinding", obs));//pour transferer vers la config du serveur
	}
	
	public void lancer(String p){
		switch (p) {
		case "EntréeServeur" : 
			String command = this.getEntree().getPoint(p).getVal();
			System.out.println("Serveur : la commande '" +command+ "' est arrivée dans le port EntréeServeur du serveur, elle doit donc etre traitée et envoyé vers le port SortieServeur" );
			this.getSortie().getPoint("SortieServeurBinding").setVal(command);
			break;
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
