package m1.configuration.connecteurs;

import m1.configuration.connecteurs.glues.GlueRPC;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.connecteur.TypeConnecteur;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.InterfaceARole;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.role.Role;
import m2.configuration.interfaces.role.RoleEntree;
import m2.configuration.interfaces.role.RoleSortie;

public class RPC extends Connecteur{

	public RPC(ObserveurdeTransit obs) {
		super(TypeConnecteur.EXPLICITE, new GlueRPC(), new InterfaceARole(), new InterfaceARole());
		
		this.getFrom().getRoles().add(new RoleEntree("Entr�eRPCdeClient"));//caller, requis
		this.getFrom().getRoles().add(new RoleEntree("Entr�eRPCdeServeur"));//caller, requis
		
		this.getTo().getRoles().add(new RoleSortie("SortieRPCdeClient",obs));//called, fourni
		this.getTo().getRoles().add(new RoleSortie("SortieRPCdeServeur",obs));//called, fourni
	}
	
	public void lancer(String p){
		String result = glue.traduit(from.getPoint(p));
		switch (p) {
		case "Entr�eRPCdeClient" :
			System.out.println("RPC : la commande '" +p+ "' est arriv� dans le port entr�eRPCdeClient du RPC, elle doit donc etre trait�e et envoy� vers le port SortieRPCdeServeur" );
			this.getTo().getPoint("SortieRPCdeServeur").setVal(result);
			break;

		case "Entr�eRPCdeServeur" :
			System.out.println("RPC : la commande '" +p+ "' est arriv� dans le port entr�eRPCdeServeur du RPC, elle doit donc etre trait�e et envoy� vers le port SortieRPCdeClient" );
			this.getTo().getPoint("SortieRPCdeClient").setVal(result);
			break;
			
		default:
			System.out.println("lancer not implemented for Connecteur");
			break;
		}
	}

}
