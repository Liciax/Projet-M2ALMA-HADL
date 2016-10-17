package m2.configuration.connecteur;

import m2.configuration.interfaces.InterfaceARole;

public abstract class Connecteur {
	
	private TypeConnecteur type;
	private Glue glue;
	private InterfaceARole from;
	private InterfaceARole to;

	
	public Connecteur(TypeConnecteur type, Glue glue, 
			InterfaceARole from, InterfaceARole to) {
		super();
		this.type = type;
		this.glue = glue;
		this.from = from;
		this.to = to;
	}
	
	
	
}
