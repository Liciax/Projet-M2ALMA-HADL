package m1.configuration;

import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;
import m2.configuration.interfaces.port.PortEntree;
import m2.configuration.interfaces.port.PortSortie;

public class ServeurConfig extends Configuration {

	public ServeurConfig() {
		super();
		ObserveurdeTransit observServ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de données
		this.getInterfConf().getPorts().add(new PortEntree("EntreeConfServ"));
		this.getInterfConf().getPorts().add(new PortSortie("SortieConfServ",observServ));
		
		//TODO : Partie basse de m1
	}

}
