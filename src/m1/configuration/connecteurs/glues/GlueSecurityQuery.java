package m1.configuration.connecteurs.glues;


import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Glue du connecteur SecurityManager
 *
 */
public class GlueSecurityQuery extends Glue {

	public String traduit(PointConnexion p) {
		LOGGER.info("GlueSecurityQuery : traduction par la glue");
		switch (p.getNom()) {// traitement peut etre different en fonction de la glue
		case "CallerDB":
			return p.getVal();

		case "CallerSecu":
			return p.getVal();

		default:
			return null;
		}
	}
}
