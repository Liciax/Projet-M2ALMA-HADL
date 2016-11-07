package m2.configuration.composant;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import m1.configuration.interfaces.InterfaceAPortConcret;
import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceAPort;

public abstract class ComposantSimple implements ComposantAbstrait{
	
		protected List<ContrainteTechnique> ct;
		protected List<Propriete> proprietes;
		protected InterfaceAPort entree;
		protected InterfaceAPort sortie;
		protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//permet gestion des affichages consoles
		
		public ComposantSimple() {
			ct = new ArrayList<ContrainteTechnique>();
			proprietes = new ArrayList<Propriete>();
			this.entree = new InterfaceAPortConcret();
			this.sortie = new InterfaceAPortConcret();
		}
		
		public void lancer(String p){
			switch (p) {
			default:
				System.out.println("lancer not implemented for ComposantSimple");
				break;
			}
		}

		public InterfaceAPort getEntree() {
			return entree;
		}

		public void setEntree(InterfaceAPort entree) {
			this.entree = entree;
		}

		public InterfaceAPort getSortie() {
			return sortie;
		}

		public void setSortie(InterfaceAPort sortie) {
			this.sortie = sortie;
		}

		public List<ContrainteTechnique> getCt() {
			return ct;
		}

		public List<Propriete> getProprietes() {
			return proprietes;
		}
		
		
}
