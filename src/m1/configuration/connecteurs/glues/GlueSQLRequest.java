package m1.configuration.connecteurs.glues;

import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Glue du connecteur SQLRequest
 *
 */
public class GlueSQLRequest extends Glue {

	public String traduit(PointConnexion p) {
		LOGGER.info("GlueClearanceRequest : traduction par la glue");
		switch (p.getNom()) {// traitement peut etre different en fonction de la glue
		case "CallerConnec":
			return p.getVal();

		case "CallerDB":
			return p.getVal();

		default:
			return null;
		}
	}
}
