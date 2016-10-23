package m1.configuration.connecteurs.glues;
import m2.configuration.connecteur.Glue;
import m2.configuration.interfaces.PointConnexion;


public class GlueSecurityQuery extends Glue {
	
	public String traduit(PointConnexion p) {
		System.out.println("GlueSecurityQuery : traduction par la glue");
		switch(p.getNom()) {//traitement peut etre different en fonction de la glue
		case "CalledDB":
			return p.getVal();

		case "CalledSecu":
			return p.getVal();
			
		default:
			return null;
		}
	}
}
