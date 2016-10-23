package m2.configuration.interfaces;

public abstract class PointConnexion {

	protected String nom;
	protected String val;

	
	public PointConnexion(String nom, String val) {
		super();
		this.nom = nom;
		this.val = val;
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
		System.out.println("PortEntree/RoleEntree : ecriture dans le port " + nom + " de la commande " + val);
		this.val = val;
	}

	
}
