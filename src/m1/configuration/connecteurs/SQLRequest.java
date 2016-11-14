package m1.configuration.connecteurs;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.connecteurs.glues.GlueSQLRequest;
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
public class SQLRequest extends Connecteur {

	public SQLRequest(ObserveurDeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueSQLRequest(), new InterfaceARoleConcret(), new InterfaceARoleConcret());

		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerConnec"));// caller,
		                                                                     // requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("CallerDB"));// caller,
		                                                                 // requis

		this.getTo().getRoles().add(new RoleSortieConcret("CalledConnec", obs));// called,
		                                                                        // fourni
		this.getTo().getRoles().add(new RoleSortieConcret("CalledDB", obs));// called,
		                                                                    // fourni
	}

	/* (non-Javadoc)
	 * @see m2.configuration.connecteur.Connecteur#lancer(java.lang.String)
	 */
	public void lancer(String p) {
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "CallerConnec":
			LOGGER.info("SQLRequest : la commande '" + result
			    + "' est arrive dans le role CalledConnec du SQLRequest, elle doit donc etre traitee et envoye vers le port CallerDB");
			this.getTo().getPoint("CalledDB").setVal(result);
			break;

		case "CallerDB":
			LOGGER.info("SQLRequest : la commande '" + result
			    + "' est arrive dans le role CalledDB du SQLRequest, elle doit donc etre traitee et envoye vers le role CallerConnec");
			this.getTo().getPoint("CalledConnec").setVal(result);
			break;

		default:
			LOGGER.severe("lancer not implemented for Connecteur");
			break;
		}
	}
}
