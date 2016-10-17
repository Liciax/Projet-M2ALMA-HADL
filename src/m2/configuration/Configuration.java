package m2.configuration;

import java.util.HashMap;

import m2.configuration.interfaces.PointConnexion;

public abstract class Configuration implements ComposantAbstrait{

	private HashMap<PointConnexion, PointConnexion> liaisons; //associe les sorties avec les entrées correspondantes
	private HashMap<PointConnexion, ComposantAbstrait> entrees; //pour un port/role donné, donne le ComposantAbstrait associe
	
	public void notifier(PointConnexion p) {
		liaisons.get(p).setVal(p.getVal());
		entrees.get(liaisons.get(p)).lancer(liaisons.get(p));
	}
	
	public void ajouterComposant(ComposantAbstrait ca) {
		
	}
	
	public void retirerComposant(ComposantAbstrait ca) {
		
	}
	
	public void lancer(PointConnexion p){
		// TODO implement this
	}
}
