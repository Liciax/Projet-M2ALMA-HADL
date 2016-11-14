package m1.configuration.ComposantsSimples;

import m1.configuration.ObserveurDeTransit;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.composant.ComposantSimple;

/**
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * La classe Serveur implemente ComposantSimple et possede 2 interfaces : une d'entree et une de sortie.
 * Elle est chargee de recevoir les requetes du client et de les traiter avant de les transferer vers le composant suivant.
 */
public class Serveur extends ComposantSimple {

	/**
	 * Constructeur de Serveur
	 * 
	 * @param obs l'observeur qui va prevenir la configuration en cas de fin de
	 *          traitement
	 */
	public Serveur(ObserveurDeTransit obs) {
		super();
		this.entree = new InterfaceAPortConcret();
		this.sortie = new InterfaceAPortConcret();
		this.setEntree(new InterfaceAPortConcret());
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeServeur"));
		this.getEntree().getPorts().add(new PortEntreeConcret("EntreeServeurBinding"));
		this.setSortie(new InterfaceAPortConcret());
		this.getSortie().getPorts().add(new PortSortieConcret("SortieServeur", obs));// pour
		                                                                             // retour
		                                                                             // vers
		                                                                             // le
		                                                                             // client
		this.getSortie().getPorts().add(new PortSortieConcret("SortieServeurBinding", obs));// pour
		                                                                                    // transferer
		                                                                                    // vers
		                                                                                    // la
		                                                                                    // config
		                                                                                    // du
		                                                                                    // serveur
	}


	/* (non-Javadoc)
	 * @see m2.configuration.composant.ComposantSimple#lancer(java.lang.String)
	 */
	public void lancer(String p) {
		String command;
		switch (p) {
		case "EntreeServeur":
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Serveur : la commande '" + command
			    + "' est arrivee dans le port EntreeServeur du serveur, elle doit donc etre traitee et envoye vers le port SortieServeur");
			this.getSortie().getPoint("SortieServeurBinding").setVal(command);
			break;
		case "EntreeServeurBinding":
			command = this.getEntree().getPoint(p).getVal();
			LOGGER.info("Serveur : la commande '" + command
			    + "' est arrivee dans le port EntreeServeurBinding du serveur, elle doit donc etre traitee et envoye vers le port Client");
			this.getSortie().getPoint("SortieServeur").setVal(command);
			break;
		default:
			LOGGER.severe("lancer not implemented for Serveur");
			break;
		}
	}
}
