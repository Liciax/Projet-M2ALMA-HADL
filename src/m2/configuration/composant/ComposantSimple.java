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
		
		public void lancer(PointConnexion p){
			// TODO implement this
		}
}
