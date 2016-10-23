package m1.configuration.interfaces.role;

import m2.configuration.interfaces.role.RoleEntree;

public class RoleEntreeConcret extends RoleEntree {

	public RoleEntreeConcret(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public void setVal(String val) {
		System.out.println("RoleEntree : ecriture dans le port " + nom + " de la commande " + val);
		this.val = val;
	}
}
