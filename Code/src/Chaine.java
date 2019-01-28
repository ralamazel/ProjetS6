import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public  class Chaine {
	private String code;
	protected HashMap<String,Double> input;
	private String nomElemenntACreer;
	protected String codeElementCreer ;
	private int quantiteSortie;
	
	
	public Chaine(String code,String nom,HashMap<String,Double> input, String codeElementCreer, Integer quantiteSortie) throws FileNotFoundException  {
		this.code=code;
		this.nomElemenntACreer=nom;
		this.input=input;
		this.codeElementCreer=codeElementCreer;
		this.quantiteSortie=quantiteSortie;
	}


	@Override
	public String toString() {
		return "Chaine [code=" + code + ", input=" + input + ", nomElemenntACreer=" + nomElemenntACreer
				+ ", codeElementCreer=" + codeElementCreer + ", quantiteSortie=" + quantiteSortie + "]";
	}


	
	
	public void fabriquer(String nomElementAFabriquer, int niveauDeFabrication) {
		
	}
	
	}