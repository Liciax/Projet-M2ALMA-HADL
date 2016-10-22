package m2.configuration.interfaces;

public abstract class PointConnexion {

	protected String val;
	protected String id;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		System.out.println("PortEntrée/RoleEntrée : ecriture dans le port " + id + " de la commande " + val);
		this.val = val;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
