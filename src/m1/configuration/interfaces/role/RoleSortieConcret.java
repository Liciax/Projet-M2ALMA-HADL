package m1.configuration.interfaces.role;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.role.RoleSortie;

public class RoleSortieConcret extends RoleSortie {

	private ObserveurdeTransit obs;

	public RoleSortieConcret(String nom, String val, ObserveurdeTransit obs) {
		super(nom, val, obs);
		this.obs = obs;
	}
	
	public void setVal(String val) {
		System.out.println("RoleSortie : ecriture dans le role " + nom + "de la commande '" + val + "', delegation de la suite a la configuration");
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
