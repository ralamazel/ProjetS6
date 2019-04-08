package coeur;
import java.io.*;
import java.util.HashMap;
import java.util.Random;

import gestionfichier.FichierCSVChaines;
import gestionfichier.FichierCSVElements;
import usine.Usine;
public class main {
		public static void main (String[] args) throws IOException {
			
			
			Usine u1=new Usine("/Users/igouane/Desktop/ProjetS6s/Code/elementsV2.csv","/Users/igouane/Desktop/ProjetS6s/Code/chainesV2.csv");
			Stock s = u1.getS();
			ChainesProduction c= u1.getC();
			
			//s.afficherStock();
			s.RemplirStockage();
			//s.afficherStockage();
			
			//c.getChaine("Chocolat 50 %").fabriquer(10, s);
			//s.afficherStockage();
			//s.afficherStockage();
			//s.ValiderLaProduction();
			

			//s.reset();*/
			HashMap<Chaine, Integer> hashmap= new HashMap<>();
			Chaine[] chaines=c.getListeDesChaines();
			for(int i=0;i<3;i++) {
				Random r=new Random();
				Integer a=r.nextInt(3);
				int niveauAct=a;
				System.out.println("Niveau d'activation de la chaine "+chaines[i].getnomElementACreer()+" : "+a);
				hashmap.put(chaines[i],niveauAct);
			}
			
			Fabrication f=new Fabrication(hashmap,s);
			//s.afficherStock();
			f.calculerProduction(s);
			//s.afficherStock();
			System.out.println(f.getListeElementConsommer());
			System.out.println("-------------------------------------");
			System.out.println(f.getListeElementFabriquer());
		}
}