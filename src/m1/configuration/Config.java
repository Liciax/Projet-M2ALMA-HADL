package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.Serveur;
import m1.configuration.connecteurs.RPC;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.PortEntreeConcret;
import m2.configuration.interfaces.port.PortSortieConcret;
import m1.configuration.ServeurConfig;

public class Config extends Configuration{

	public Config() {
		super();
		this.id = "ConfigGenerale";
		ObserveurdeTransit observ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de données
		this.getInterfConf().getPorts().add(new PortEntreeConcret("EntreeConf"));
		this.getInterfConf().getPorts().add(new PortSortieConcret("SortieConf",observ));
		
		
		Client cli = new Client(observ);
		this.listeComposants.add(cli);
		
		RPC rpc = new RPC(observ);
		this.listeComposants.add(rpc);
		this.liaisons.put(cli.getSortie().getPoint("SortieClient"), rpc.getFrom().getPoint("EntréeRPCdeClient"));//Client->RPC
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeClient"), cli.getEntree().getPoint("EntréeClient"));//RCP->Client
		
		Serveur serv = new Serveur(observ);
		this.listeComposants.add(serv);
		this.liaisons.put(serv.getSortie().getPoint("SortieServeur"), rpc.getFrom().getPoint("EntréeRPCdeServeur"));//Serveur->RCP
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeServeur"), serv.getEntree().getPoint("EntréeServeur"));//RCP->Serveur
		

		ServeurConfig confServ = new ServeurConfig();//config serveur
		this.listeComposants.add(confServ);
		this.liaisons.put(serv.getSortie().getPoint("SortieServeurBinding"), confServ.getInterfConf().getPoint("EntreeConfServ"));//Binding Sortie de serv -> Entrée de ConfServ
		
		
		
		this.entrees.put(cli.getEntree().getPoint("EntréeClient"), cli);
		this.entrees.put(rpc.getFrom().getPoint("EntréeRPCdeClient"), rpc);
		this.entrees.put(rpc.getFrom().getPoint("EntréeRPCdeServeur"), rpc);
		this.entrees.put(serv.getEntree().getPoint("EntréeServeur"), serv);
		this.entrees.put(confServ.getInterfConf().getPoint("EntreeConfServ"), confServ);
		
		
		
		
		//3 bindings: entre serveur et serveurConfig, entre Serveur et config et ???
	}
	
	public void begin(String command) {
		((Client)this.getListeComposants().get(0)).prepare(command);
	}
	
	public static void main(String[] args){
		Config conf = new Config();
		conf.begin("lets-a-go");
	}
}
