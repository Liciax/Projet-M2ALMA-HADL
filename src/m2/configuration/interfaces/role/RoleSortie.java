package m2.configuration.interfaces.role;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.PointConnexion;

public class RoleSortie extends Role {

	private ObserveurdeTransit obs;

	public RoleSortie(ObserveurdeTransit obs) {
		super();
		this.obs = obs;
	}

	public void notifierEnvoi() {
		obs.notifier(this);
	}

	@Override
	public void lancer(PointConnexion p) {
		// TODO Auto-generated method stub
		
	}
}
