package m2.configuration.connecteur;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceARole;
import m2.configuration.interfaces.PointConnexion;

public abstract class Connecteur implements ComposantAbstrait{
	
	protected TypeConnecteur type;
	protected Glue glue;
	protected InterfaceARole from;
	protected InterfaceARole to;

	
	public void lancer(PointConnexion p){
		String result = glue.traduit(p);
		switch (p.getId()) {
		default:
			System.out.println("lancer not implemented for Connecteur");
			break;
		}
	}


	public TypeConnecteur getType() {
		return type;
	}


	public void setType(TypeConnecteur type) {
		this.type = type;
	}


	public Glue getGlue() {
		return glue;
	}


	public void setGlue(Glue glue) {
		this.glue = glue;
	}


	public InterfaceARole getFrom() {
		return from;
	}


	public void setFrom(InterfaceARole from) {
		this.from = from;
	}


	public InterfaceARole getTo() {
		return to;
	}


	public void setTo(InterfaceARole to) {
		this.to = to;
	}
	
	
}
