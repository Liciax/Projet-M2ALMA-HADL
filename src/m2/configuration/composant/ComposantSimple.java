package m2.configuration.composant;

import java.util.List;

import m2.configuration.interfaces.InterfaceAPort;

public abstract class ComposantSimple {

		private ContrainteTechnique ct;
		private List<Propriete> proprietes;
		private InterfaceAPort entree;
		private InterfaceAPort sorti;
}
