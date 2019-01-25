import java.io.FileNotFoundException;

public class ChaineDrone extends Chaine{
	
	public ChaineDrone() throws FileNotFoundException{
		this.input= new QuantiteElement[3];
		
		input[0]= new QuantitePropulsion(24);
		input[1]= new QuantiteCoque(1);
		input[2] = new QuantiteCircuitPrincipal(8);
		this.output= new QuantiteElement[1];

		output[0]= new QuantiteDrone(4);
	}
	
	
	public void fabriquer() {
		
	}
}
