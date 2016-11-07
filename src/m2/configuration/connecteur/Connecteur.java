package m2.configuration.connecteur;

import java.util.logging.Logger;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceARole;

public abstract class Connecteur implements ComposantAbstrait{
	
	protected TypeConnecteur type;
	protected Glue glue;
	protected InterfaceARole from;
	protected InterfaceARole to;
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	

	
	
	public Connecteur(TypeConnecteur type, Glue glue, InterfaceARole from, InterfaceARole to) {
		super();
		this.type = type;
		this.glue = glue;
		this.from = from;
		this.to = to;
	}


	public void lancer(String p){
		//String result = glue.traduit(from.getPoint(p));
		switch (p) {
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
