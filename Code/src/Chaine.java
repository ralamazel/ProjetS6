import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public  class Chaine {
	
	private String code;
	private HashMap<String,Double> input;
	private String nomElementACreer;
	private String codeElementCreer ;
	private int quantiteSortie;
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public HashMap<String, Double> getInput() {
		return input;
	}


	public void setInput(HashMap<String, Double> input) {
		this.input = input;
	}


	public String getNomElementACreer() {
		return nomElementACreer;
	}


	public void setNomElementACreer(String nomElementACreer) {
		this.nomElementACreer = nomElementACreer;
	}


	public String getCodeElementCreer() {
		return codeElementCreer;
	}


	public void setCodeElementCreer(String codeElementCreer) {
		this.codeElementCreer = codeElementCreer;
	}


	public int getQuantiteSortie() {
		return quantiteSortie;
	}


	public void setQuantiteSortie(int quantiteSortie) {
		this.quantiteSortie = quantiteSortie;
	}

	
	public Chaine(String code,String nom,HashMap<String,Double> input, String codeElementCreer, Integer quantiteSortie) throws FileNotFoundException  {
		this.code=code;
		this.nomElementACreer=nom;
		this.input=input;
		this.codeElementCreer=codeElementCreer;
		this.quantiteSortie=quantiteSortie;
	}


	@Override
	public String toString() {
		return "Chaine [code=" + code + ", input=" + input + ", nomElementACreer=" + nomElementACreer
				+ ", codeElementCreer=" + codeElementCreer + ", quantiteSortie=" + quantiteSortie + "]";
	}

	
	
	
	public void fabriquer( int niveauDeFabrication,Stock s) {
		for (String el : input.keySet()) {
				// enlever quantité pr chq el
				
		}
	}
	
}