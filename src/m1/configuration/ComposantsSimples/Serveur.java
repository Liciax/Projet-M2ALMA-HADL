package m1.configuration.ComposantsSimples;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.composant.ComposantSimple;
import m2.configuration.interfaces.port.PortEntreeConcret;
import m2.configuration.interfaces.port.PortSortieConcret;

public class Serveur extends ComposantSimple{

	public Serveur(ObserveurdeTransit obs) {
		super();
		this.setEntree(new InterfaceAPortConcret());//lui ajouter 1 ports vers RCP
		this.getEntree().getPorts().add(new PortEntreeConcret("EntréeServeur"));
		this.setSortie(new InterfaceAPortConcret());//lui ajouter 1 port vers RCP + obs
		this.getSortie().getPorts().add(new PortSortieConcret("SortieServeur", obs));//pour retour vers le client
		this.getSortie().getPorts().add(new PortSortieConcret("SortieServeurBinding", obs));//pour transferer vers la config du serveur
	}
	
	public void lancer(String p){
		switch (p) {
		case "EntréeServeur" : 
			String command = this.getEntree().getPoint(p).getVal();
			System.out.println("Serveur : la commande '" +command+ "' est arrivée dans le port EntréeServeur du serveur, elle doit donc etre traitée et envoyé vers le port SortieServeur" );
			this.getSortie().getPoint("SortieServeurBinding").setVal(command);
			break;
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
}
