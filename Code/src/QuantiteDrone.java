import java.io.FileNotFoundException;

public class QuantiteDrone extends QuantiteElement{
	public QuantiteDrone(int quantite) throws FileNotFoundException{
		super(new Drone(),quantite);
	}
}
