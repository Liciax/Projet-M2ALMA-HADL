package m1.configuration.connecteurs;

import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;

public class GlueClearanceRequest extends Glue {

	public String traduit(PointConnexion p) {
		System.out.println("GlueRPC : traduction par la glue");
		switch(p.getNom()) {//traitement peut etre different en fonction de la glue
		case "CalledConnec":
			return p.getVal();

		case "CalledSecu":
			return p.getVal();
			
		default:
			return null;
		}
	}
}
