import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ChainesProduction {
		
		private int ind=0;
		private  static Chaine[] ListeDesChaines;
		
		/** 
		 * Le constructeur de la classe chainesProduction.
		 * @throws FileNotFoundException : le stock va chercher dans elements.csv
		 */
		public ChainesProduction() throws FileNotFoundException {
			
			ChainesProduction.ListeDesChaines = new Chaine[10];
			String fileName = "chaines.csv";
			File file = new File(fileName);

			Scanner s = new Scanner(file);
			s.nextLine();
			
			String data="";
			while(s.hasNext()) {
				HashMap<String,Double> chaine=new HashMap<String,Double>();
				
				data = s.nextLine();
				String[] values = data.split(";");
				String code = values[0];
				String[] input = values[2].split(",");
				
			
				
				
				for(int i=0;i<input.length;i++) {
					
					String[] ok=input[i].split("x");
					
					chaine.put(ok[0], Double.valueOf(ok[1]));
					
				}
				String[] output = values[3].split("x");
				
				Chaine c=new Chaine(code,values[1],chaine,output[0],Double.valueOf(output[1]));
				ChainesProduction.ListeDesChaines[this.ind]=c;
				this.ind=this.ind+1;
				
			}
			s.close();
	}
		
	
		/**
		 * Méthode permettant de trouver la chaine de production correspondante à l'élément que l'on veut créer
		 * @param nomElement : l'élément dont on recherche la chaîne de production
		 * @return null si l'élément n'est pas trouvé sinon la chaine de production de l'élément
		 */
		public Chaine getChaine(String nomElement) {
			for (int i=0;i<this.ind;i++) {
				if(ChainesProduction.ListeDesChaines[i].getnomElementACreer().equals(nomElement)){
					return ListeDesChaines[i];
				}
			}
			System.out.println("La chaine n'a pas été trouvé.");
			return null;
		}
		
		
}