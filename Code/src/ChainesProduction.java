import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ChainesProduction {
	
	
		private  static Chaine[] ListeDesChaines;
		
		public ChainesProduction() throws FileNotFoundException {
			this.ListeDesChaines = new Chaine[10];
			String fileName = "chaines.csv";
			File file = new File(fileName);

			Scanner s = new Scanner(file);
			s.nextLine();
			
			String data="";
			while(s.hasNext()) {
				int numb=0;
				
				data = s.nextLine();
				String[] values = data.split(";");
				String code = values[0];
				String[] input = values[2].split("+");
				
				QuantiteElement[] a= new QuantiteElement[10];
				
				
				for(int i=0;i<input.length;i++) {
					String[] ok=input[i].split(",");
					int quantite=Integer.valueOf(ok[1]);
					String codeElement=ok[0];
					a[i]=new QuantiteElement(codeElement,quantite);
				}
				String[] output = values[3].split(",");
				
				Chaine c=new Chaine(code,a,output[0],Integer.valueOf(output[1]));
				ChainesProduction.ListeDesChaines[numb]=c;
				
			}
			s.close();
	}
		
		

}
