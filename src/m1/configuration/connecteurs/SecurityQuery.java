package m1.configuration.connecteurs;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.connecteurs.glues.GlueSecurityQuery;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 *
 */
public class SecurityQuery extends Connecteur {

	public SecurityQuery(ObserveurDeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueSecurityQuery(), new InterfaceARoleConcret(), new InterfaceARoleConcret());

		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerDB"));// caller,
		                                                                 // requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerSecu"));// caller,
		                                                                   // requis

		this.getTo().getRoles().add(new RoleSortieConcret("CalledDB", obs));// called,
		                                                                    // fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CalledSecu", obs));// called,
		                                                                      // fourni
	}

	/* (non-Javadoc)
	 * @see m2.configuration.connecteur.Connecteur#lancer(java.lang.String)
	 */
	public void lancer(String p) {
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "CallerDB":
			LOGGER.info("SecurityQuery : la commande '" + result
			    + "' est arrive dans le port CalledDB du SecurityQuery, elle doit donc etre traitee et envoye vers le port CallerSecu");
			this.getTo().getPoint("CalledSecu").setVal(result);
			break;

		case "CallerSecu":
			LOGGER.info("SecurityQuery : la commande '" + result
			    + "' est arrive dans le port CalledSecu du SecurityQuery, elle doit donc etre traitee et envoye vers le port CallerDB");
			this.getTo().getPoint("CalledDB").setVal(result);
			break;

		default:
			LOGGER.severe("lancer not implemented for Connecteur");
			break;
		}
	}
}
