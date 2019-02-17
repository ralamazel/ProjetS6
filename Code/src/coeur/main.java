package coeur;
import java.io.*;

import gestionfichier.FichierCSVChaines;
import gestionfichier.FichierCSVElements;
import usine.Usine;
public class main {
		public static void main (String[] args) throws IOException {
			
			
			Usine u1=new Usine("elementsV2.csv","chainesV2.csv");
			Stock s = u1.getS();
			ChainesProduction c= u1.getC();
			
			s.afficherStock();
			s.RemplirStockage();
			
			
			//s.afficherElement("Pate Madeleines Q2");
			c.getChaine("Chocolat 50 %").fabriquer(3, s);
			s.afficherStockage();
			s.afficherStock();
			if (s.Examiner()) {
				System.out.println("Efficacite : "+s.getEfficacite()+" euros \n");
				s.ValiderLaProduction();
			}
			//s.ValiderLaProduction();
			//s.reset();
		}
}