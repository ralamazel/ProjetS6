import java.io.FileNotFoundException;

public class QuantiteCircuitPrincipal extends QuantiteElement{
	
	public QuantiteCircuitPrincipal(double quantite) throws FileNotFoundException{
		super(new CircuitPrincipal(),quantite);
	}
}
