package m2.configuration.interfaces.role;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite Service represente le concept de service du metamodele.
 */
public abstract class RoleEntree extends Role {

	/**
	 * Constructeur de role en entree.
	 * @param nom le nom du role en entree
	 */
	public RoleEntree(String nom) {
		super(nom);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub	
	}
	
}