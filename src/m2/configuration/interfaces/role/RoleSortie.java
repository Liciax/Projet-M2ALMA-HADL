package m2.configuration.interfaces.role;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.PointConnexion;

public abstract class RoleSortie extends Role {

	private ObserveurdeTransit obs;

	public void notifierEnvoi() {
		obs.notifier(this);
	}
}
