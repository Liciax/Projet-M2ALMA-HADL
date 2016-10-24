package m1.configuration;

import m1.configuration.ComposantsSimples.ConnectionManager;
import m1.configuration.ComposantsSimples.Database;
import m1.configuration.ComposantsSimples.SecurityManager;
import m1.configuration.connecteurs.ClearanceRequest;
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
		
		ConnectionManager connectionManager = new ConnectionManager(observServ);
		this.listeComposants.add(connectionManager);
		
		Database dataBase = new Database(observServ);
		this.listeComposants.add(dataBase);
		
		SecurityManager securityManager = new SecurityManager(observServ);
		this.listeComposants.add(securityManager);
		
		/************************************************************************Connecteurs de la configuration**********************************************************************************************/
		
		ClearanceRequest clearanceRequest = new ClearanceRequest(observServ);
		this.listeComposants.add(clearanceRequest);
		
		SecurityQuery securityQuery = new SecurityQuery(observServ);
		this.listeComposants.add(securityQuery);
		
		SQLRequest sqlRequest = new SQLRequest(observServ);
		this.listeComposants.add(sqlRequest);
		
		/************************************************************************Liaisons Attachements********************************************************************************************************/

		this.liaisons.put(connectionManager.getSortie().getPoint("Send_SecurityCheck"), clearanceRequest.getFrom().getPoint("CallerConnec"));//connectionManager->clearance Request
		this.liaisons.put(clearanceRequest.getTo().getPoint("CalledConnec"), connectionManager.getEntree().getPoint("Receive_SecurityCheck"));//clearance Request->connectionManager
		this.liaisons.put(securityManager.getSortie().getPoint("Send_SecurityAnthPort"), clearanceRequest.getFrom().getPoint("CallerSecu"));//Serveur->RCP
		this.liaisons.put(clearanceRequest.getTo().getPoint("CalledSecu"), securityManager.getEntree().getPoint("Receive_SecurityAnthPort"));//RCP->Serveur
		
		this.liaisons.put(dataBase.getSortie().getPoint("Send_SecurityManagementPort"), securityQuery.getFrom().getPoint("CallerDB"));//Client->RPC
		this.liaisons.put(securityQuery.getTo().getPoint("CalledDB"), dataBase.getEntree().getPoint("Receive_SecurityManagementPort"));//RCP->Client
		this.liaisons.put(securityManager.getSortie().getPoint("Send_ConnexionQueryPort"), securityQuery.getFrom().getPoint("CallerSecu"));//Serveur->RCP
		this.liaisons.put(securityQuery.getTo().getPoint("CalledSecu"), securityManager.getEntree().getPoint("Receive_ConnexionQueryPort"));//RCP->Serveur
		
		this.liaisons.put(connectionManager.getSortie().getPoint("Send_DBQuery"), sqlRequest.getFrom().getPoint("CallerConnec"));//Client->RPC
		this.liaisons.put(sqlRequest.getTo().getPoint("CalledConnec"), connectionManager.getEntree().getPoint("Receive_DBQuery"));//RCP->Client
		this.liaisons.put(dataBase.getSortie().getPoint("Send_QueryIntPort"), sqlRequest.getFrom().getPoint("CallerDB"));//Serveur->RCP
		this.liaisons.put(sqlRequest.getTo().getPoint("CalledDB"), dataBase.getEntree().getPoint("Receive_QueryIntPort"));//RCP->Serveur
		
		/************************************************************************Liaisons Bindings************************************************************************************************************/
	
//		this.liaisons.put(serv.getSortie().getPoint("SortieServeurBinding"), confServ.getInterfConf().getPoint("EntreeConfServ"));//Binding Sortie de serv -> Entree de ConfServ
		
		/*********************************************************************************************************************************************************************************/
		
		this.entrees.put(connectionManager.getEntree().getPoint("Receive_SecurityCheck"), connectionManager);
		this.entrees.put(connectionManager.getEntree().getPoint("Receive_ExternalSocket"), connectionManager);
		this.entrees.put(connectionManager.getEntree().getPoint("Receive_DBQuery"), connectionManager);
			
		this.entrees.put(securityManager.getEntree().getPoint("Receive_SecurityAnthPort"), securityManager);
		this.entrees.put(securityManager.getEntree().getPoint("Receive_ConnexionQueryPort"), securityManager);
		
		this.entrees.put(dataBase.getEntree().getPoint("Receive_SecurityManagementPort"), dataBase);
		this.entrees.put(dataBase.getEntree().getPoint("Receive_QueryIntPort"), dataBase);
		
		this.entrees.put(clearanceRequest.getFrom().getPoint("CallerConnec"), clearanceRequest);
		this.entrees.put(clearanceRequest.getFrom().getPoint("CallerSecu"), clearanceRequest);

		this.entrees.put(securityQuery.getFrom().getPoint("CallerSecu"), securityQuery);
		this.entrees.put(securityQuery.getFrom().getPoint("CallerDB"), securityQuery);
		
		this.entrees.put(sqlRequest.getFrom().getPoint("CallerDB"), sqlRequest);
		this.entrees.put(sqlRequest.getFrom().getPoint("CallerConnec"), sqlRequest);
			
		//3 bindings: entre serveur et serveurConfig, entre Serveur et config et ???

	}
	
//	public void begin(String command) {
//		((Client)this.getListeComposants().get(0)).prepare(command);
//	}


	public void lancer(String p){
		System.out.println("on est bien arrivee pour le moment");
	}
}
