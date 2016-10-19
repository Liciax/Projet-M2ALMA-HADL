package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.connecteurs.RPC;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.PortEntree;
import m2.configuration.interfaces.port.PortSortie;
import m1.configuration.ServeurConfig;

public class Config extends Configuration{

	public Config() {
		super();
		ObserveurdeTransit observ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de données
		this.getInterfConf().getPorts().add(new PortEntree("EntreeConf"));
		this.getInterfConf().getPorts().add(new PortSortie("SortieConf",observ));
		
		
		ServeurConfig confServ = new ServeurConfig();//config serveur
		this.listeComposants.add(confServ);
		
		Client cli = new Client(observ);
		this.listeComposants.add(cli);
		
		
		
		RPC rpc = new RPC(observ);
		this.listeComposants.add(rpc);
		
		

		//3 bindings: entre serveur et serveurConfig, entre Serveur et config et ???
	}
	
	public static void main(String[] args){
		
	}
}
