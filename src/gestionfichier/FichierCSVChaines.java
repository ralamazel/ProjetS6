package gestionfichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import coeur.Chaine;
import coeur.ChainesProduction;

public class FichierCSVChaines extends FichierCSV{
	private  static Chaine[] ListeDesChaines;
	private int ind;
	
	public FichierCSVChaines(String CheminFichierChaines) {
		this.path=new File(CheminFichierChaines);
	}
	
	public Chaine[] Charger()  {
		ListeDesChaines = new Chaine[40];

		Scanner s;
		try {
			s = new Scanner(this.path);
			s.nextLine();
			
			String data="";
			while(s.hasNext()) {
				HashMap<String,Double> input=new HashMap<String,Double>();
				HashMap<String,Double> output=new HashMap<String,Double>();
				data = s.nextLine();
				String[] values = data.split(";");
				String code = values[0];
				String[] codeQteInput = values[2].split(",");
				String[] codeQteOutput = values[3].split(",");
			
				for(int i=0;i<codeQteInput.length;i++) {
					
					String[] ok=codeQteInput[i].split("x");
					input.put(ok[0], Double.valueOf(ok[1]));
				}
				
				for(int i=0;i<codeQteOutput.length;i++) {
					String[] ok= codeQteOutput[i].split("x");
					output.put(ok[0], Double.valueOf(ok[1]));
				}
				
				Chaine c=new Chaine(code,values[1],input,output,Integer.parseInt(values[4]));
				ListeDesChaines[this.ind]=c;
				this.ind=this.ind+1;
				
			}
			s.close();
			return ListeDesChaines;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Le fichier n'a pas �t� trouv�");
		}
		System.out.println("Probl�me liste de chaines vide");
		return null;
	}
	
	public int getInd() {
		return this.ind;
	}

	@Override
	public void Ecriture() {
		//boutaleb
	}

}