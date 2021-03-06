package m1.configuration.connecteurs.glues;

import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Glue du connecteur RPC
 *
 */
public class GlueRPC extends Glue {

	public String traduit(PointConnexion p) {
		LOGGER.info("GlueRPC : traduction par la glue");
		switch (p.getNom()) {// traitement peut etre different en fonction de la glue
		case "EntreeRPCdeClient":
			return p.getVal();

		case "EntreeRPCdeServeur":
			return p.getVal();

		default:
			return null;
		}
	}

}
