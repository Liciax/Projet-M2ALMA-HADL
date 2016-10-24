package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.Serveur;
import m1.configuration.connecteurs.RPC;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.PointConnexion;
import m1.configuration.ServeurConfig;

public class Config extends Configuration{

	
	public Config(ObserveurdeTransit o) {
		super(o);
		
		/************************************************************************Elements propre a la configuration*******************************************************************************************/
		this.id = "ConfigGenerale";
		ObserveurdeTransit observ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de donnees
		this.getInterfConf().getPorts().add(new PortEntreeConcret("EntreeConf"));
		this.getInterfConf().getPorts().add(new PortSortieConcret("SortieConf",o));
		
		
		/************************************************************************Composants de la configuration***********************************************************************************************/
		
		Client cli = new Client(observ);
		this.listeComposants.add(cli);

		Serveur serv = new Serveur(observ);
		this.listeComposants.add(serv);
		
		ServeurConfig confServ = new ServeurConfig(observ);//config serveur
		this.listeComposants.add(confServ);
		
		/************************************************************************Connecteurs de la configuration**********************************************************************************************/
		
		RPC rpc = new RPC(observ);
		this.listeComposants.add(rpc);
		
		/************************************************************************Liaisons Attachements********************************************************************************************************/
		
		this.liaisons.put(cli.getSortie().getPoint("SortieClient"), rpc.getFrom().getPoint("EntreeRPCdeClient"));//Client->RPC
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeClient"), cli.getEntree().getPoint("EntreeClient"));//RCP->Client
		this.liaisons.put(serv.getSortie().getPoint("SortieServeur"), rpc.getFrom().getPoint("EntreeRPCdeServeur"));//Serveur->RCP
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeServeur"), serv.getEntree().getPoint("EntreeServeur"));//RCP->Serveur
		
		/************************************************************************Liaisons Bindings************************************************************************************************************/
		
		this.liaisons.put(serv.getSortie().getPoint("SortieServeurBinding"), confServ.getInterfConf().getPoint("EntreeConfServ"));//Binding Sortie de serv -> Entree de ConfServ
		this.liaisons.put(confServ.getInterfConf().getPoint("SortieConfServ"), serv.getEntree().getPoint("EntreeServeurBinding"));//Binding Sortie de serv -> Entree de ConfServ

		
		/*********************************************************************************************************************************************************************************/
		
		this.entrees.put(cli.getEntree().getPoint("EntreeClient"), cli);
		this.entrees.put(rpc.getFrom().getPoint("EntreeRPCdeClient"), rpc);
		this.entrees.put(rpc.getFrom().getPoint("EntreeRPCdeServeur"), rpc);
		this.entrees.put(serv.getEntree().getPoint("EntreeServeur"), serv);
		this.entrees.put(serv.getEntree().getPoint("EntreeServeurBinding"), serv);
		this.entrees.put(confServ.getInterfConf().getPoint("EntreeConfServ"), confServ);
		
	
		
		//3 bindings: entre serveur et serveurConfig, entre Serveur et config et ???
	}
	
	public void begin(String command) {
		((Client)this.getListeComposants().get(0)).prepare(command);
	}
	
	public static void main(String[] args){
		Config conf = new Config(null);
		conf.begin("Connexion:blabla");
		System.out.println("        *          ");
		System.out.println("        *          ");
		System.out.println("        *          ");
		System.out.println("        *          ");
		System.out.println("        *          ");
		conf.begin("Query:LOL");
	}
}
