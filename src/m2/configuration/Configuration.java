package m2.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;

public abstract class Configuration implements ComposantAbstrait{

	protected HashMap<PointConnexion, PointConnexion> liaisons; //associe les sorties avec les entrées correspondantes
	protected HashMap<PointConnexion, ComposantAbstrait> entrees; //pour un port/role donné, donne le ComposantAbstrait associe
	protected List<ComposantAbstrait> listeComposants;
	protected InterfaceAPort interfConf;
	protected String id;
	
	
	public Configuration(ObserveurdeTransit o) {
		this.entrees = new HashMap<PointConnexion, ComposantAbstrait>();
		this.liaisons = new HashMap<PointConnexion, PointConnexion>();
		this.listeComposants = new ArrayList<ComposantAbstrait>();
		this.interfConf = new InterfaceAPortConcret();
	}
	
	public void notifier(PointConnexion p) {
		System.out.println("\nConfiguration : " +p.getNom() + " souhaite envoyer un message. envoi du message au port correspondant: " + liaisons.get(p).getNom() + " et signalement au ComposantAbstrait correspondant");
		liaisons.get(p).setVal(p.getVal());
		entrees.get(liaisons.get(p)).lancer(liaisons.get(p).getNom());
	}

	
	public void lancer(String p){
		// TODO implement this
	}


	public HashMap<PointConnexion, PointConnexion> getLiaisons() {
		return liaisons;
	}


	public void addLiaisons(PointConnexion dep, PointConnexion arriv) {
		this.liaisons.put(dep, arriv);
	}


	public HashMap<PointConnexion, ComposantAbstrait> getEntrees() {
		return entrees;
	}


	public void addEntrees(PointConnexion entree, ComposantAbstrait compRecevant) {
		this.entrees.put(entree, compRecevant);
	}

	public InterfaceAPort getInterfConf() {
		return interfConf;
	}

	public void setInterfConf(InterfaceAPort interfConf) {
		this.interfConf = interfConf;
	}
	
	public List<ComposantAbstrait> getListeComposants() {
		return listeComposants;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
