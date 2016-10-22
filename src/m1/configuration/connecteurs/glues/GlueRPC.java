package m1.configuration.connecteurs.glues;

import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;

public class GlueRPC extends Glue{

	public String traduit(PointConnexion p) {
		System.out.println("GlueRPC : traduction par la glue");
		switch(p.getId()) {//traitement peut etre different en fonction de la glue
		case "EntréeRPCdeClient":
			return p.getVal();

		case "EntréeRPCdeServeur":
			return p.getVal();
			
		default:
			return null;
		}
	}
	
}
