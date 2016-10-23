package m1.configuration.interfaces.port;

import m2.configuration.interfaces.port.PortEntree;

public class PortEntreeConcret extends PortEntree {

	public PortEntreeConcret(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}
	

	public void setVal(String val) {
		System.out.println("PortEntree : ecriture dans le port " + nom + " de la commande " + val);
		this.val = val;
	}

}
