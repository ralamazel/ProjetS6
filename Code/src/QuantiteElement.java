import java.io.FileNotFoundException;

public abstract class QuantiteElement {
	private Element e;
	private double quantite;
	public QuantiteElement(Element e, double quantite) throws FileNotFoundException {
		this.e=e;
		this.quantite=quantite;
		
	}
	
	public void miseAjourQuantite() {
		
	}

}
