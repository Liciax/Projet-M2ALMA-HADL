package m2.configuration.interfaces;

public abstract class PointConnexion {

	protected String nom;
	protected String val;

	
	public PointConnexion(String nom) {
		super();
		this.nom = nom;
		this.val = null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String id) {
		this.nom = id;
	}
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	
}
