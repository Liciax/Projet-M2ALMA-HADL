package m1.configuration;

import m1.configuration.ComposantsSimples.Client;
import m1.configuration.ComposantsSimples.ConnectionManager;
import m1.configuration.ComposantsSimples.Database;
import m1.configuration.ComposantsSimples.SecurityManager;
import m1.configuration.connecteurs.ClearanceRequest;
import m1.configuration.connecteurs.RPC;
import m1.configuration.connecteurs.SQLRequest;
import m1.configuration.connecteurs.SecurityQuery;
import m1.configuration.interfaces.port.PortEntreeConcret;
import m1.configuration.interfaces.port.PortSortieConcret;
import m2.configuration.Configuration;
import m2.configuration.ObserveurdeTransit;

public class ServeurConfig extends Configuration {

	public ServeurConfig() {
		super();
		
		/************************************************************************Elements propre a la configuration*******************************************************************************************/

		this.id = "ConfigServeur";
		ObserveurdeTransit observServ = new ObserveurdeTransit(this);//observeur qui va regarder tout les ports de sortie pour lancer l'envoi de donnees
		this.getInterfConf().getPorts().add(new PortEntreeConcret("EntreeConfServ"));
		this.getInterfConf().getPorts().add(new PortSortieConcret("SortieConfServ",observServ));
		
		/************************************************************************Composants de la configuration***********************************************************************************************/
		
		ConnectionManager ConnMana = new ConnectionManager(observServ);
		this.listeComposants.add(ConnMana);
		
		Database db = new Database(observServ);
		this.listeComposants.add(db);
		
		SecurityManager secuMana = new SecurityManager(observServ);
		this.listeComposants.add(secuMana);
		
		/************************************************************************Connecteurs de la configuration**********************************************************************************************/
		
		ClearanceRequest clearReq = new ClearanceRequest(observServ);
		this.listeComposants.add(clearReq);
		
		SecurityQuery secuQuery = new SecurityQuery(observServ);
		this.listeComposants.add(secuQuery);
		
		SQLRequest sqlReq = new SQLRequest(observServ);
		this.listeComposants.add(sqlReq);
		
		/************************************************************************Liaisons Attachements********************************************************************************************************/
//		TODO: changer les noms des string
		this.liaisons.put(ConnMana.getSortie().getPoint("SortieClient"), clearReq.getFrom().getPoint("EntreeRPCdeClient"));//Client->RPC
		this.liaisons.put(clearReq.getTo().getPoint("SortieRPCdeClient"), ConnMana.getEntree().getPoint("EntreeClient"));//RCP->Client
		this.liaisons.put(secuMana.getSortie().getPoint("SortieServeur"), clearReq.getFrom().getPoint("EntreeRPCdeServeur"));//Serveur->RCP
		this.liaisons.put(clearReq.getTo().getPoint("SortieRPCdeServeur"), secuMana.getEntree().getPoint("EntreeServeur"));//RCP->Serveur
		
		this.liaisons.put(db.getSortie().getPoint("SortieClient"), secuQuery.getFrom().getPoint("EntreeRPCdeClient"));//Client->RPC
		this.liaisons.put(secuQuery.getTo().getPoint("SortieRPCdeClient"), db.getEntree().getPoint("EntreeClient"));//RCP->Client
		this.liaisons.put(secuMana.getSortie().getPoint("SortieServeur"), secuQuery.getFrom().getPoint("EntreeRPCdeServeur"));//Serveur->RCP
		this.liaisons.put(secuQuery.getTo().getPoint("SortieRPCdeServeur"), secuMana.getEntree().getPoint("EntreeServeur"));//RCP->Serveur
		
		this.liaisons.put(ConnMana.getSortie().getPoint("SortieClient"), sqlReq.getFrom().getPoint("EntreeRPCdeClient"));//Client->RPC
		this.liaisons.put(sqlReq.getTo().getPoint("SortieRPCdeClient"), ConnMana.getEntree().getPoint("EntreeClient"));//RCP->Client
		this.liaisons.put(db.getSortie().getPoint("SortieServeur"), sqlReq.getFrom().getPoint("EntreeRPCdeServeur"));//Serveur->RCP
		this.liaisons.put(sqlReq.getTo().getPoint("SortieRPCdeServeur"), db.getEntree().getPoint("EntreeServeur"));//RCP->Serveur
		
		/************************************************************************Liaisons Bindings************************************************************************************************************/
//		TODO: mettres les entrées et binding
//		this.liaisons.put(serv.getSortie().getPoint("SortieServeurBinding"), confServ.getInterfConf().getPoint("EntreeConfServ"));//Binding Sortie de serv -> Entr�e de ConfServ
//		
//		/*********************************************************************************************************************************************************************************/
//		
//		this.entrees.put(cli.getEntree().getPoint("Entr�eClient"), cli);
//		this.entrees.put(rpc.getFrom().getPoint("Entr�eRPCdeClient"), rpc);
//		this.entrees.put(rpc.getFrom().getPoint("Entr�eRPCdeServeur"), rpc);
//		this.entrees.put(serv.getEntree().getPoint("Entr�eServeur"), serv);
//		this.entrees.put(confServ.getInterfConf().getPoint("EntreeConfServ"), confServ);
		
		
		
		
		//3 bindings: entre serveur et serveurConfig, entre Serveur et config et ???
	}
	
//	public void begin(String command) {
//		((Client)this.getListeComposants().get(0)).prepare(command);
//	}


	public void lancer(String p){
		System.out.println("on est bien arrivee pour le moment");
	}
}
