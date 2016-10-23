package m1.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.Port;

public abstract class PortSortie extends Port {

	protected ObserveurdeTransit obs;

	public PortSortie(String nom) {
		super(nom);
	}

	public void setVal(String val) {
		System.out.println("PortSortie : ecriture dans le port " + id + " de la commande '" + val + "', delegation de la suite a la configuration");
		this.val = val;
		notifierEnvoi();
	}

	public void notifierEnvoi() {
		obs.notifier(this);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub
		
	}

}