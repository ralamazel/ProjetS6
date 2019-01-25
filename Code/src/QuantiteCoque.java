import java.io.FileNotFoundException;

public class QuantiteCoque extends QuantiteElement{
	public QuantiteCoque(int quantite) throws FileNotFoundException {
		super(new Coque(),quantite);
	}
}
