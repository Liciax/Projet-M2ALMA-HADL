package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.Serveur;
import m1.configuration.connecteurs.RPC;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.PortEntree;
import m2.configuration.interfaces.port.PortSortie;
import m1.configuration.ServeurConfig;

public class Config extends Configuration{

	public Config() {
		super();
		ObserveurdeTransit observ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de donn�es
		this.getInterfConf().getPorts().add(new PortEntree("EntreeConf"));
		this.getInterfConf().getPorts().add(new PortSortie("SortieConf",observ));
		
		
		Client cli = new Client(observ);
		this.listeComposants.add(cli);
		
		RPC rpc = new RPC(observ);
		this.listeComposants.add(rpc);
		this.liaisons.put(cli.getSortie().getPoint("SortieClient"), rpc.getFrom().getPoint("Entr�eRPCdeClient"));
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeClient"), cli.getEntree().getPoint("Entr�eClient"));
		
		Serveur serv = new Serveur(observ);
		this.listeComposants.add(serv);
		this.liaisons.put(serv.getSortie().getPoint("SortieServeur"), rpc.getFrom().getPoint("Entr�eRPCdeServeur"));
		this.liaisons.put(rpc.getTo().getPoint("SortieRPCdeServeur"), serv.getEntree().getPoint("Entr�eServeur"));
		

		this.entrees.put(cli.getEntree().getPoint("Entr�eClient"), cli);
		this.entrees.put(rpc.getFrom().getPoint("Entr�eRPCdeClient"), rpc);
		this.entrees.put(rpc.getFrom().getPoint("Entr�eRPCdeServeur"), rpc);
		this.entrees.put(serv.getEntree().getPoint("Entr�eClient"), serv);

		ServeurConfig confServ = new ServeurConfig();//config serveur
		this.listeComposants.add(confServ);
		
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
