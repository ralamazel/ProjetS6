import java.io.FileNotFoundException;

public class QuantitePropulsion extends QuantiteElement{
	
		public QuantitePropulsion(double quantite) throws FileNotFoundException{
			super(new Propulsion(),quantite);
		}
	}

