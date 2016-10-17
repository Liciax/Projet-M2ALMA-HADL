package m2.configuration.connecteur;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.PointConnexion;

public abstract class Connecteur implements ComposantAbstrait{
	
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
	public void lancer(PointConnexion p){
		// TODO implement this
	}
>>>>>>> 85e992e294a73e0f72dfb2aea98c101ff5e841d6
}
