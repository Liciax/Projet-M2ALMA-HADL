package m1.configuration.connecteurs.glues;

import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;

public class GlueClearanceRequest extends Glue {

	public String traduit(PointConnexion p) {
		System.out.println("GlueClearanceRequest : traduction par la glue");
		switch(p.getNom()) {//traitement peut etre different en fonction de la glue
		case "CallerConnec":
			return p.getVal();

		case "CallerSecu":
			return p.getVal();
			
		default:
			return null;
		}
	}
}
