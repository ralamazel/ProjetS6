package gestionfichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import coeur.Element;

public class FichierCSVElements extends FichierCSV{
	
	private final static HashMap<Element, Double> hmap = new HashMap<>();
	private String tout="";
	
	public FichierCSVElements(String cheminFichierElements) {
		this.path= new File(cheminFichierElements);
	}
	
	public HashMap<Element, Double>  Charger() {
	    
		int prixVente,prixAchat;
		Scanner s;
		try {
			s = new Scanner(path);
			this.tout=this.tout+"Code;Nom;Quantite;unite;achat;vente;stockage;demande\n";
			s.nextLine();
			
			String data = "";
			while(s.hasNext()) {
				data = s.nextLine();
				this.tout=this.tout+data+"\n";
				String[] values = data.split(";");
				int demande = Integer.parseInt(values[7]);
				if(!values[4].equals("NA")) {
					 prixAchat=Integer.valueOf(values[4]); 
				}
				else {
					prixAchat=0;
				}
				
				if(!values[5].equals("NA")) {
					prixVente = Integer.valueOf(values[5]);
				}
				else {
					prixVente=0;
				}

				Element e = new Element(values[0],values[1],values[3],prixAchat,prixVente,values[6],demande) ;
				
				hmap.put(e, Double.valueOf(values[2]));
			}
			s.close();
			return hmap;
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("hmap nulle");
		return null;
		
	}
	
	public void Ecriture() {
		//boutaleb
	}
	

}