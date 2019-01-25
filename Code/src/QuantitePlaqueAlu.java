import java.io.FileNotFoundException;

public class QuantitePlaqueAlu extends QuantiteElement{
	
	public QuantitePlaqueAlu(double quantite) throws FileNotFoundException{
		super(new PlaqueAlu(),quantite);
	}

}
