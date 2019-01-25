import java.io.FileNotFoundException;

public class QuantiteServomoteur extends QuantiteElement{
	
	public QuantiteServomoteur(double quantite) throws FileNotFoundException{
		super(new Servomoteur(),quantite);
	}
}
