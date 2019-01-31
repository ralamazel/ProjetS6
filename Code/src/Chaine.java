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
	protected HashMap<String,Double> input;
	private String nomElementACreer;
	protected String codeElementCreer ;
	private Double quantiteSortie;
	
	
	/**
	 * Le constructeur de la classe Chaine
	 * @param code 
	 * @param nom : le nom d'un élément à créer
	 * @param input : la hashmap contenant les noms des éléments composants ainsi que leur quantité en stock
	 * @param codeElementCreer : le code de l'élément à créer
	 * @param quantiteSortie : la quantité de l'élément en sortie de production
	 * @throws FileNotFoundException
	 */
	public Chaine(String code,String nom,HashMap<String,Double> input, String codeElementCreer, Double quantiteSortie) throws FileNotFoundException  {
		this.code=code;
		this.nomElementACreer=nom;
		this.input=input;
		this.codeElementCreer=codeElementCreer;
		this.quantiteSortie=quantiteSortie;
	}


	
	public String toString() {
		return "Chaine [code=" + code + ", input=" + input + ", nomElemenntACreer=" + nomElementACreer
				+ ", codeElementCreer=" + codeElementCreer + ", quantiteSortie=" + quantiteSortie + "]";
	}


	
	
	/**
	 * @param niveauDeFabrication : le niveau de fabrication d'un élément
	 * @param s :  le stock dans lequel l'élément sera créé
	 * cette méthode permet de fabriquer un élément selon un niveau de fabrication
	 */
	public void fabriquer(int niveauDeFabrication, Stock s) {
		
		
		s.AjoutStock(this.codeElementCreer, this.quantiteSortie*niveauDeFabrication);
		Set<String> set = this.input.keySet();
		Iterator<String> it = set.iterator();
		
		for (Entry<String, Double> entry : this.input.entrySet())
		{
			
			String test=(String) it.next();
			double quantiteSortie=entry.getValue();
			quantiteSortie = quantiteSortie*niveauDeFabrication;
			s.EnleveStock(test, quantiteSortie);
		}
		
		
		
	}
	


	
	public String getnomElementACreer() {
		return this.nomElementACreer;
	}

}