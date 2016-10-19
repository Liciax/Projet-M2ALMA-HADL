package m2.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;

public abstract class Configuration implements ComposantAbstrait{

	protected HashMap<PointConnexion, PointConnexion> liaisons; //associe les sorties avec les entrées correspondantes
	protected HashMap<PointConnexion, ComposantAbstrait> entrees; //pour un port/role donné, donne le ComposantAbstrait associe
	protected List<ComposantAbstrait> listeComposants;
	protected InterfaceAPort interfConf;
	
	public Configuration() {
		this.entrees = new HashMap<PointConnexion, ComposantAbstrait>();
		this.liaisons = new HashMap<PointConnexion, PointConnexion>();
		this.listeComposants = new ArrayList<ComposantAbstrait>();
		interfConf = new InterfaceAPort();
	}
	
	public void notifier(PointConnexion p) {
		liaisons.get(p).setVal(p.getVal());
		entrees.get(liaisons.get(p)).lancer(liaisons.get(p));
	}

	
	public void lancer(PointConnexion p){
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
	
	
	
	
}
