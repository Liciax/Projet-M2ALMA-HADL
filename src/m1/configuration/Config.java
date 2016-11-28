package m1.configuration;

import m1.configuration.ServeurConfig;
import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.Serveur;
import m1.configuration.connecteurs.RPC;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.Configuration;

import java.util.logging.Logger;
/**
 * 
 * @author Lenny Lucas
 * @author Alicia Boucard 
 * Classe representant la configuration principale, englobant tout les autres composants
 *
 */
public class Config extends Configuration {

	public Config(ObserveurDeTransit o) {
		super(o);

		/************************************************************************
		 * Elements propre a la configuration
		 *******************************************************************************************/
		this.id = "ConfigGenerale";
		ObserveurDeTransit observ = new ObserveurDeTransit(this);// observeur qui va
		                                                         // regarder tout
		                                                         // les ports de
		                                                         // sortie pour
		                                                         // lancer l'envoi
		                                                         // de donnees
		this.interfaceConfiguration = new InterfaceAPortConcret();
		this.getInterfaceConfiguration().getPorts().add(new PortEntreeConcret("EntreeConf"));
		this.getInterfaceConfiguration().getPorts().add(new PortSortieConcret("SortieConf", observ));

		/************************************************************************
		 * Composants de la configuration
		 ***********************************************************************************************/

		Client cli = new Client(observ);
		this.listeComposants.add(cli);

		Serveur serv = new Serveur(observ);
		this.listeComposants.add(serv);

		ServeurConfig confServ = new ServeurConfig(observ);// config serveur
		this.listeComposants.add(confServ);

		/************************************************************************
		 * Connecteurs de la configuration
		 **********************************************************************************************/

		RPC rpc = new RPC(observ);
		this.listeComposants.add(rpc);

		/************************************************************************
		 * Liaisons Attachements
		 ********************************************************************************************************/

		this.liaisons.put(cli.getSortie().getPoint("SortieClient"), rpc.getFrom().getPoint("EntreeRPCdeClient"));// Client->RPC
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeClient"), cli.getEntree().getPoint("EntreeClient"));// RCP->Client
		this.liaisons.put(serv.getSortie().getPoint("SortieServeur"), rpc.getFrom().getPoint("EntreeRPCdeServeur"));// Serveur->RCP
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeServeur"), serv.getEntree().getPoint("EntreeServeur"));// RCP->Serveur

		/************************************************************************
		 * Liaisons Bindings
		 ************************************************************************************************************/

		this.liaisons.put(this.getInterfaceConfiguration().getPoint("SortieConf"),
		    cli.getEntree().getPoint("EntreeClientBinding"));// Binding entree
		                                                     // Config -> entree
		                                                     // Client
		this.liaisons.put(serv.getSortie().getPoint("SortieServeurBinding"),
		    confServ.getInterfaceConfiguration().getPoint("EntreeConfServ"));// Binding
		                                                                     // Sortie
		                                                                     // de
		                                                                     // serv
		                                                                     // ->
		                                                                     // Entree
		                                                                     // de
		                                                                     // ConfServ
		this.liaisons.put(confServ.getInterfaceConfiguration().getPoint("SortieConfServ"),
		    serv.getEntree().getPoint("EntreeServeurBinding"));// Binding Sortie de
		                                                       // ConfServ -> Entree
		                                                       // de serv

		/*********************************************************************************************************************************************************************************/

		this.entrees.put(this.getInterfaceConfiguration().getPoint("EntreeConf"), this);
		this.entrees.put(cli.getEntree().getPoint("EntreeClientBinding"), cli);

		this.entrees.put(cli.getEntree().getPoint("EntreeClient"), cli);
		this.entrees.put(rpc.getFrom().getPoint("EntreeRPCdeClient"), rpc);
		this.entrees.put(rpc.getFrom().getPoint("EntreeRPCdeServeur"), rpc);
		this.entrees.put(serv.getEntree().getPoint("EntreeServeur"), serv);
		this.entrees.put(serv.getEntree().getPoint("EntreeServeurBinding"), serv);
		this.entrees.put(confServ.getInterfaceConfiguration().getPoint("EntreeConfServ"), confServ);

	}

	/*
	 * @see m2.configuration.ComposantAbstrait#lancer(java.lang.String)
	 */
	public void lancer(String p) {
		switch (p) {
		case "EntreeConf":
			String command = this.getInterfaceConfiguration().getPoint(p).getVal();
			LOGGER.info("Lien Binding : la commande '" + command + "' doit etre transferée vers le client");
			this.getInterfaceConfiguration().getPoint("SortieConf").setVal(command);
			break;

		case "SortieConf":
			break;

		default:
			LOGGER.severe("lancer not implemented for Serveur");
			break;
		}
	}

}
