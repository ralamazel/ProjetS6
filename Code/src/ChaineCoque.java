import java.io.FileNotFoundException;

//Chaine coque
public class ChaineCoque extends Chaine{

	public ChaineCoque(int n) throws FileNotFoundException{
		this.input= new QuantiteElement[2];
		
		input[0]= new QuantitePlastique(5*n);
		input[1]= new QuantitePlaqueAlu(1*n);
		this.output= new QuantiteElement[1];

		output[0]= new QuantiteCoque(10*n);
		
		//int newQuantite=(int)hmap.put(2,"BB");
	       
	    //System.out.println("Valeur remplacée : "+val_ret);
	       
	    //System.out.println("Hashtable après modification : "+ht); 
		
	}
	
	
	public void fabriquer(int niveau) {
		//return output[0];
		
	}
}
