package m2.configuration.interfaces.port;

/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard
 * La classe abstraite PortEntree represente le concept de port d'entree du metamodele.
 */
public abstract class PortEntree extends Port {

	/**
	 * Constructeur de port d'entree.
	 * @param nom le nom du port d'entree
	 */
	public PortEntree(String nom) {
		super(nom);
	}

	@Override
	public void lancer(String p) {
		// TODO Auto-generated method stub	
	}

}
