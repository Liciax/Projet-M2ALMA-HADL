package m1.configuration.ComposantsSimples;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;

public class Client extends ComposantSimple{

	public Client(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPort());//lui ajouter 1 ports vers RCP
		this.setSortie(new InterfaceAPort());//lui ajouter 1 port vers RCP + obs
	}
	
	public void lancer(PointConnexion p){
		switch (p.getId()) {
		default:
			System.out.println("lancer not implemented for Client");
			break;
		}
	}
}
