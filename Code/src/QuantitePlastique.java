import java.io.FileNotFoundException;

public class QuantitePlastique extends QuantiteElement{
	public QuantitePlastique(double quantite) throws FileNotFoundException{
		super(new Plastique(),quantite);
		
	}
}
