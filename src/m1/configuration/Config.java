package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.Serveur;
import m1.configuration.connecteurs.RPC;
import m1.configuration.interfaces.InterfaceAPortConcret;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;
import m1.configuration.ServeurConfig;
import java.util.logging.Logger;

public class Config extends Configuration{

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
	
	public Config(ObserveurdeTransit o) {
		super(o);
		
		/************************************************************************Elements propre a la configuration*******************************************************************************************/
		this.id = "ConfigGenerale";
		ObserveurdeTransit observ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de donnees
		this.interfaceConfiguration = new InterfaceAPortConcret();
		this.getInterfConf().getPorts().add(new PortEntreeConcret("EntreeConf"));
		this.getInterfConf().getPorts().add(new PortSortieConcret("SortieConf",observ));
		
		
		
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
		
		this.liaisons.put(this.getInterfConf().getPoint("SortieConf"), cli.getEntree().getPoint("EntreeClientBinding"));//Binding entree Config -> entree Client
		this.liaisons.put(serv.getSortie().getPoint("SortieServeurBinding"), confServ.getInterfConf().getPoint("EntreeConfServ"));//Binding Sortie de serv -> Entree de ConfServ
		this.liaisons.put(confServ.getInterfConf().getPoint("SortieConfServ"), serv.getEntree().getPoint("EntreeServeurBinding"));//Binding Sortie de ConfServ -> Entree de serv

		
		/*********************************************************************************************************************************************************************************/
		
		this.entrees.put(this.getInterfConf().getPoint("EntreeConf"), this);
		this.entrees.put(cli.getEntree().getPoint("EntreeClientBinding"), cli);
		
		this.entrees.put(cli.getEntree().getPoint("EntreeClient"), cli);
		this.entrees.put(rpc.getFrom().getPoint("EntreeRPCdeClient"), rpc);
		this.entrees.put(rpc.getFrom().getPoint("EntreeRPCdeServeur"), rpc);
		this.entrees.put(serv.getEntree().getPoint("EntreeServeur"), serv);
		this.entrees.put(serv.getEntree().getPoint("EntreeServeurBinding"), serv);
		this.entrees.put(confServ.getInterfConf().getPoint("EntreeConfServ"), confServ);
		
	
		
		//3 bindings: entre serveur et serveurConfig, entre Serveur et config et ???
	}
	
	public void lancer(String p){
		String command = null;
		switch (p) {
		case "EntreeConf" : 
			LOGGER.info("Lien Binding : la commande " + command + "doit etre transferée vers le client");
			command = this.getInterfConf().getPoint(p).getVal();
			this.getInterfConf().getPoint("SortieConf").setVal(command);
			break;
			
		case "SortieConf" : 
			break;
			
		default:
			System.out.println("lancer not implemented for Serveur");
			break;
		}
	}
	
//	public void begin(String command) {
//		((Client)this.getListeComposants().get(0)).prepare(command);
//	}
	
	public static void main(String[] args){
		Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
		Config conf = new Config(null);
		conf.getInterfConf().getPoint("EntreeConf").setVal("Connexion:blabla");
		String sepa = "        *          " + System.getProperty("line.separator");
		conf.lancer("EntreeConf");
		LOGGER.info(sepa + sepa + sepa +sepa);
		conf.getInterfConf().getPoint("EntreeConf").setVal("Query:LOL");
		conf.lancer("EntreeConf");
	}
}
