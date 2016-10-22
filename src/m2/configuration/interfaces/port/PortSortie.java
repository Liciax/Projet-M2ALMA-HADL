package m2.configuration.interfaces.port;

import m2.configuration.ObserveurdeTransit;

public class PortSortie extends Port {

	private ObserveurdeTransit obs;
	
	public PortSortie(String nom, ObserveurdeTransit o) {
		super(nom);
		this.obs = o;
		// TODO Auto-generated constructor stub
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
