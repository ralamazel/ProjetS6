package coeur;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import java.util.Set;

/**
 * @author jefsk
 *
 */
/**
 * @author jefsk
 *
 */
/**
 * @author jefsk
 *
 */
public  class Chaine {
	private String code;
	private HashMap<String,Double> input;
	private String nomElementACreer;
	private HashMap <String,Double> output;
	
	
	/**
	 * Le constructeur de la classe Chaine
	 * @param code 
	 * @param nom : le nom d'un element a creer
	 * @param input : la hashmap contenant les noms des elements composants ainsi que leur quantite en stock
	 * @param codeElementCreer : le code de l'element a creer
	 * @param quantiteSortie : la quantite de l'element en sortie de production
	 * @throws FileNotFoundException
	 */
	public Chaine(String code,String nom,HashMap<String,Double> input, HashMap <String,Double> output ) throws FileNotFoundException  {
		this.code=code;
		this.nomElementACreer=nom;
		this.input=input;
		this.output=output;
	}


	/**
	 * @param niveauDeFabrication : le niveau de fabrication d'un element
	 * @param s :  le stock dans lequel l'element sera cree
	 * cette methode permet de fabriquer un element selon un niveau de fabrication
	 */
	public void fabriquer(int niveauDeFabrication, Stock s) {
		Set<String> setOut = this.output.keySet();
		Iterator<String> itOut = setOut.iterator();
		boolean possible=true;
		for (Entry<String, Double> entry : this.output.entrySet())
			{
				String test=(String) itOut.next();
				
				
				possible=s.AjoutStock(test, entry.getValue()*niveauDeFabrication);
			}
		
		Set<String> setIn = this.input.keySet();
		Iterator<String> itIn = setIn.iterator();
		if(possible==true) {
			
		
		for (Entry<String, Double> entry : this.input.entrySet())
		{
			
			String test=(String) itIn.next();
			double quantiteSortie=entry.getValue();
			quantiteSortie = quantiteSortie*niveauDeFabrication;
			s.EnleveStock(test, quantiteSortie);
		}
		}
		
	}
	


	
	public String getnomElementACreer() {
		return this.nomElementACreer;
	}

}