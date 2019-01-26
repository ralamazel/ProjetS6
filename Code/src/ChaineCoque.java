import java.io.FileNotFoundException;


public class ChaineCoque extends Chaine{

	public ChaineCoque(int n) throws FileNotFoundException {
		this.input= new QuantiteElement[2];
		input[0]= new QuantitePlastique(5*n);
		input[1]= new QuantitePlaqueAlu(1*n);
		
		this.output= new QuantiteElement[1];
		output[0]= new QuantiteCoque(10*n);
		
		
		
	}
	
	
	public void fabriquer(int niveau) {
		//return output[0];
		
	}
}
