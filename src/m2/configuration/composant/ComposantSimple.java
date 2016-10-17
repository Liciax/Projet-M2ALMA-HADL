package m2.configuration.composant;

import java.util.List;

import m2.configuration.interfaces.InterfaceAPort;

public abstract class ComposantSimple {

		private ContrainteTechnique ct;
		private List<Propriete> proprietes;
		private InterfaceAPort entree;
		private InterfaceAPort sorti;
		
		
		public ComposantSimple(ContrainteTechnique ct, List<Propriete> proprietes,
				InterfaceAPort entree, InterfaceAPort sorti) {
			super();
			this.ct = ct;
			this.proprietes = proprietes;
			this.entree = entree;
			this.sorti = sorti;
		}
		
		
}
