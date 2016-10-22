package m2.configuration.interfaces.role;

import m2.configuration.ObserveurdeTransit;

public class RoleSortie extends Role {

	private ObserveurdeTransit obs;

	public RoleSortie(String nom, ObserveurdeTransit obs) {
		super(nom);
		this.obs = obs;
	}
	
	public void setVal(String val) {
		System.out.println("RoleSortie : ecriture dans le role " + id + "de la commande '" + val + "', delegation de la suite a la configuration");
		this.val = val;
		this.notifierEnvoi();
	}

	public void notifierEnvoi() {
		obs.notifier(this);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}
}
