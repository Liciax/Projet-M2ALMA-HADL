package m2.configuration.connecteur;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceARole;
import m2.configuration.interfaces.PointConnexion;

public abstract class Connecteur implements ComposantAbstrait{
	
	private TypeConnecteur type;
	private Glue glue;
	private InterfaceARole from;
	private InterfaceARole to;

	public void lancer(PointConnexion p){
		// TODO implement this
	}
}
