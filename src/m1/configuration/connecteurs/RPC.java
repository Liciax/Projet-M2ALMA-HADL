package m1.configuration.connecteurs;

import m1.configuration.connecteurs.glues.GlueRPC;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.connecteur.Connecteur;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.InterfaceARole;
import m2.configuration.interfaces.PointConnexion;
import m2.configuration.interfaces.role.Role;
import m2.configuration.interfaces.role.RoleEntree;
import m2.configuration.interfaces.role.RoleSortie;

public class RPC extends Connecteur{

	public RPC(ObserveurdeTransit obs) {
		this.setFrom(new InterfaceARole());
		this.getFrom().getRoles().add(new RoleSortie(obs));//caller, requis
		this.setTo(new InterfaceARole());
		this.getTo().getRoles().add(new RoleEntree());//called, fourni
		this.setGlue(new GlueRPC());
	}

}
