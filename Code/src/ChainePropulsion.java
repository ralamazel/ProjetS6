
public class ChainePropulsion extends Chaine{
	

		public ChainePropulsion() {
			this.input= new QuantiteElement[3];
			
			input[0]= new QuantiteServomoteur(1);
			input[1]= new QuantitePlastique(0.5);
			input[2]= new QuantitePlaqueAlu(0.1);
			this.output= new QuantiteElement[1];

			output[0]= new QuantitePropulsion(1);
		}
		
		
		public void fabriquer() {
			
		}
	}
}
