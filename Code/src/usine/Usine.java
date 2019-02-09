package usine;

import java.io.IOException;

import coeur.Chaine;
import coeur.ChainesProduction;
import coeur.Stock;

public class Usine{
	private Stock s;
	private ChainesProduction c;
	
	public Usine(String cheminStock,String cheminChaines) throws IOException {
		this.s=new Stock(cheminStock);
		this.c=new ChainesProduction(cheminChaines);
	}

	
	public Stock getS() {
		return s;
	}

	public ChainesProduction getC() {
		return c;
	}

}