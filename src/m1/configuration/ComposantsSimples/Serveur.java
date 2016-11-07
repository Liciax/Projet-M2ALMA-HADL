package m1.configuration.ComposantsSimples;

import java.util.logging.Logger;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;

public class Serveur extends ComposantSimple{

	
	public Serveur(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeServeur"));
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeServeurBinding"));
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("SortieServeur", obs));//pour retour vers le client
		this.getSortie().getPorts().add(new PortSortieConcret("SortieServeurBinding", obs));//pour transferer vers la config du serveur
	}
	
	public void lancer(String p){
		String command;
		switch (p) {
		case "EntreeServeur" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Serveur : la commande '" +command+ "' est arrivee dans le port EntreeServeur du serveur, elle doit donc etre traitee et envoye vers le port SortieServeur" );
			this.getSortie().getPoint("SortieServeurBinding").setVal(command);
			break;
		case "EntreeServeurBinding" : 
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Serveur : la commande '" +command+ "' est arrivee dans le port EntreeServeurBinding du serveur, elle doit donc etre traitee et envoye vers le port Client" );
			this.getSortie().getPoint("SortieServeur").setVal(command);
			break;
		default:
			LOGGER.info("lancer not implemented for Serveur");
			break;
		}
	}
}
