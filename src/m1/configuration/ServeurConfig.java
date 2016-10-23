package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.ConnectionManager;
import m1.configuration.ComposantsSimples.Database;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;

public class ServeurConfig extends Configuration {

	public ServeurConfig() {
		super();
		this.id = "ConfigServeur";
		ObserveurdeTransit observServ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de donnees
		this.getInterfConf().getPorts().add(new PortEntreeConcret("EntreeConfServ"));
		this.getInterfConf().getPorts().add(new PortSortieConcret("SortieConfServ",observServ));
		
		ConnectionManager ConnMana = new ConnectionManager(observServ);
		this.listeComposants.add(ConnMana);
		
		Database db = new Database(observServ);
		this.listeComposants.add(db);
		
		SecurityManager secuMana = new SecurityManager(observServ);
		this.listeComposants.add(secuMana);
	}

	public void lancer(String p){
		System.out.println("on est bien arrivee pour le moment");
	}
}
