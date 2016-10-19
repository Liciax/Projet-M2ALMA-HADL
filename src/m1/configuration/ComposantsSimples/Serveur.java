package m1.configuration.ComposantsSimples;

import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;

public class Serveur extends ComposantSimple{

	public Serveur() {
		this.setEntree(new InterfaceAPort());//lui ajouter 2 ports vers RCP et vers config
		this.setSortie(new InterfaceAPort());//lui ajouter 1 port vers RCP
	}
	
	public void lancer(PointConnexion p){
		switch (p.getId()) {
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
