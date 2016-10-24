package m1.configuration.connecteurs;

import m1.configuration.connecteurs.glues.GlueRPC;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.InterfaceARoleConcret;
import m1.configuration.interfaces.role.RoleEntreeConcret;
import m1.configuration.interfaces.role.RoleSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.role.Role;

public class RPC extends Connecteur{

	public RPC(ObserveurdeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueRPC(), new InterfaceARoleConcret(), new InterfaceARoleConcret());
		
		this.getFrom().getRoles().add(new RoleEntreeConcret("EntreeRPCdeClient"));//called, requis
		this.getFrom().getRoles().add(new RoleEntreeConcret("EntreeRPCdeServeur"));//called, requis
		
		this.getTo().getRoles().add(new RoleSortieConcret("SortieRPCdeClient",obs));//caller, fourni
		this.getTo().getRoles().add(new RoleSortieConcret("SortieRPCdeServeur",obs));//caller, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "EntreeRPCdeClient" :
			System.out.println("RPC : la commande '" +p+ "' est arrive dans le port EntreeRPCdeClient du RPC, elle doit donc etre traitee et envoye vers le port SortieRPCdeServeur" );
			this.getTo().getPoint("SortieRPCdeServeur").setVal(result);
			break;

		case "EntreeRPCdeServeur" :
			System.out.println("RPC : la commande '" +p+ "' est arrive dans le port EntreeRPCdeServeur du RPC, elle doit donc etre traitee et envoye vers le port SortieRPCdeClient" );
			this.getTo().getPoint("SortieRPCdeClient").setVal(result);
			break;
			
		default:
			System.out.println("lancer not implemented for Connecteur");
			break;
		}
	}

}
