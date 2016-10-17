package m2.configuration.composant;

import java.util.List;

import m2.configuration.ComposantAbstrait;
import m2.configuration.interfaces.InterfaceAPort;
import m2.configuration.interfaces.PointConnexion;

public abstract class ComposantSimple implements ComposantAbstrait{

		private ContrainteTechnique ct;
		private List<Propriete> proprietes;
		private InterfaceAPort entree;
		private InterfaceAPort sortie;
		
		
		public ComposantSimple(ContrainteTechnique ct, List<Propriete> proprietes,
				InterfaceAPort entree, InterfaceAPort sorti) {
			super();
			this.ct = ct;
			this.proprietes = proprietes;
			this.entree = entree;
			this.sortie = sorti;
		}
		
		public void lancer(PointConnexion p){
			// TODO implement this
		}
}
