package coeur;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import gestionfichier.FichierCSVChaines;

public class ChainesProduction {
		
		private  Chaine[] ListeDesChaines;
		private FichierCSVChaines c;
		private int ind;
		/** 
		 * Le constructeur de la classe chainesProduction.
		 * @throws FileNotFoundException : le stock va chercher dans elements.csv
		 */
		public ChainesProduction(String CheminFichierChaines) throws FileNotFoundException {
			this.c=new FichierCSVChaines(CheminFichierChaines);
			this.ListeDesChaines=c.Charger();
			this.ind=c.getInd();
			
	}
		
	
		/**
		 * Methode permettant de trouver la chaine de production correspondante a l'element que l'on veut creer
		 * @param nomElement : l'element dont on recherche la chaine de production
		 */
		public Chaine getChaine(String nomElement) {
			for (int i=0;i<this.ind;i++) {
				
				if(ListeDesChaines[i].getnomElementACreer().equals(nomElement)){
					return ListeDesChaines[i];
				}
			}
			System.out.println("La chaine n'a pas ete trouve.");
			return null;
		}
		
		
}