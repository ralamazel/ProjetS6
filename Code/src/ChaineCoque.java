//Chaine coque
public class ChaineCoque extends Chaine{

	public ChaineCoque() {
		this.input= new QuantiteElement[2];
		
		input[0]= new QuantitePlastique(5);
		input[1]= new QuantitePlaqueAlu(1);
		this.output= new QuantiteElement[1];

		output[0]= new QuantiteCoque(10);
	}
	
	
	public void fabriquer() {
		
	}
}
