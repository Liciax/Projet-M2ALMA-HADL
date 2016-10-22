package m2.configuration.composant;

import java.util.ArrayList;
import java.util.List;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceAPort;

public abstract class ComposantSimple implements ComposantAbstrait{

		protected List<ContrainteTechnique> ct;
		protected List<Propriete> proprietes;
		protected InterfaceAPort entree;
		protected InterfaceAPort sortie;
		
		public ComposantSimple() {
			ct = new ArrayList<ContrainteTechnique>();
			proprietes = new ArrayList<Propriete>();
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
