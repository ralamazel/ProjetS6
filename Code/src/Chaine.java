import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import java.util.Set;

public  class Chaine {
	private String code;
	protected HashMap<String,Double> input;
	private String nomElementACreer;
	protected String codeElementCreer ;
	private Double quantiteSortie;
	
	
	public Chaine(String code,String nom,HashMap<String,Double> input, String codeElementCreer, Double quantiteSortie) throws FileNotFoundException  {
		this.code=code;
		this.nomElementACreer=nom;
		this.input=input;
		this.codeElementCreer=codeElementCreer;
		this.quantiteSortie=quantiteSortie;
	}


	@Override
	public String toString() {
		return "Chaine [code=" + code + ", input=" + input + ", nomElemenntACreer=" + nomElementACreer
				+ ", codeElementCreer=" + codeElementCreer + ", quantiteSortie=" + quantiteSortie + "]";
	}


	
	
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