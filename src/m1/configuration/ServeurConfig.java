package m1.configuration;

import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;

public class ServeurConfig extends Configuration {

	public ServeurConfig() {
		super();
		this.id = "ConfigServeur";
		ObserveurdeTransit observServ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de donn�es
		this.getInterfConf().getPorts().add(new PortEntreeConcret("EntreeConfServ"));
		this.getInterfConf().getPorts().add(new PortSortieConcret("SortieConfServ",observServ));
		
		//TODO : Partie basse de m1
	}

	public void lancer(String p){
		System.out.println("on est bien arriv� pour le moment");
	}
}
