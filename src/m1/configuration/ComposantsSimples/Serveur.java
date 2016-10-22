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
		this.getSortie().getPorts().add(new PortSortie("SortieServeur", obs));
	}
	
	public void lancer(String p){
		switch (p) {
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
