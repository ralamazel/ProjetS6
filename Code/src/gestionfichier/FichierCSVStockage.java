package gestionfichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import coeur.Chaine;
import coeur.Stockage;

public class FichierCSVStockage extends FichierCSV {
	private Stockage[] stockages;
	private int ind;
	
	public FichierCSVStockage(String CheminFichierStockage) {
		this.path=new File(CheminFichierStockage);
	}
	
	public Stockage[] Charger() {
		stockages = new Stockage[40];
		Scanner s;
		try {
			s = new Scanner(this.path);
			s.nextLine();
			
			String data="";
			while(s.hasNext()) {
				data=s.nextLine();
				String[] ajout=data.split(";");
				Stockage st=new Stockage(ajout[0],ajout[1],Integer.parseInt(ajout[2]),Integer.parseInt(ajout[3]));
				this.stockages[this.ind]=st;
				this.ind++;
			}
		
	}catch (FileNotFoundException e) {
		System.out.println("Le fichier n'a pas �t� trouv�");
	}
		return this.stockages;
	}
	public int getInd() {
		return this.ind;
	}
	
	public void Ecriture() {
		
}
	
}
