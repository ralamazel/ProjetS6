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
	 * @param nom : le nom d'un �l�ment � cr�er
	 * @param input : la hashmap contenant les noms des �l�ments composants ainsi que leur quantit� en stock
	 * @param codeElementCreer : le code de l'�l�ment � cr�er
	 * @param quantiteSortie : la quantit� de l'�l�ment en sortie de production
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
	 * @param niveauDeFabrication : le niveau de fabrication d'un �l�ment
	 * @param s :  le stock dans lequel l'�l�ment sera cr��
	 * cette m�thode permet de fabriquer un �l�ment selon un niveau de fabrication
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