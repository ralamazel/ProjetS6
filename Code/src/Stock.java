import java.util.HashMap;
import java.lang.Object;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import javafx.scene.shape.Path;
import java.lang.*;
import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardCopyOption.*;
public class Stock {
	private final static HashMap<Element, Double> hmap = new HashMap<>();
	private String tout="";
	private FileWriter f;
	private double efficacite;
	/**
	 * Le constructeur de la classe Stock
	 * @throws IOException 
	 */
	public Stock() throws IOException {
		File file = new File("elements.csv");
	    
		int prixVente,prixAchat;
		
		Scanner s = new Scanner(file);
		this.tout=this.tout+"Code;Nom;Quantite;unite;achat;vente\n";
		s.nextLine();
		
		String data = "";
		while(s.hasNext()) {
			
			data = s.nextLine();
			this.tout=this.tout+data+"\n";
			String[] values = data.split(";");
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

			Element e = new Element(values[0],values[1],values[3],prixAchat,prixVente) ;
			
			hmap.put(e, Double.valueOf(values[2]));
		}
		s.close();
		this.efficacite=this.getEfficacite();
	}	
	      
		

	
	/**
	 * Methode permettant d'afficher le stock
	 */
	public void afficherStock() {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			System.out.println ("Nom : "+test.getNom()+" | Quantite : "+entry.getValue());
		}
		System.out.println ();
	}
	
	/**
	 * @param nom : nom de l'element dont on cherche la quantite
	 * @return la quantite de l'element ou 1 si le nom de l'element n'est pas dans la hashmap
	 */
	public Double getQuantite(String nom) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getNom().equals(nom)){
				return(entry.getValue());
			}
		}
		return 1.0;
	}
	
	
	
	/**
	 * Methode permettant d'ajouter une quantite d'element au stock a partir de son code
	 * @param code : code de l'element 
	 * @param quantite : quantite de l'element a ajouter au stock
	 */
	public void AjoutStock(String code, Double quantite) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getCode().equals(code)) {
				entry.setValue(entry.getValue() + quantite);
			}
			
		}

	}
	
	/**
	 * methode permettant de retirer du stock une quantite de l'element a partir de son code
	 * @param code : code de l'element a retirer du stock
	 * @param quantite :  quantite de l'element a retirer du stock
	 */
	public void EnleveStock(String code, double quantite) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getCode().equals(code)) {
				entry.setValue(entry.getValue() - quantite);
			}
			
		}

	}


	
	/**
	 * Permet de verifier si l'element peut-etre produit
	 * @throws IOException 
	 */
	public boolean Examiner() throws IOException {
		f = new FileWriter("Liste d'achats");
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if(entry.getValue()<0) {
				
				if(test.getPrixAchat()==0) {
					System.out.println("Production impossible car l'element "+test.getNom()+ " ne possede pas de prix d'achat");
					return false;
				}
				else {
					f.append(test.getNom()+" : "+entry.getValue()+ " unites à acheter.\n");
				}
				
			}
		}
		System.out.println("Production possible");
		f.close();
		return true;
	}
	
	/**
	 * Methode calculant l'efficacite de la production
	 */
	public double getEfficacite() {
		double eff;
		double valeurAchat=0;
		double valeurVenteStock=0;
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (entry.getValue()>0) {
				valeurVenteStock= valeurVenteStock + (entry.getValue()*test.getPrixVente());
				
			}
			else {
				valeurAchat= valeurAchat + (-1*(entry.getValue()*test.getPrixAchat()));
			}
		}
		eff=valeurVenteStock-valeurAchat;
		return eff;
	}
	
	
	/**
	 * Methode permettant de valider la production effectuee et de l'inscrire dans le fichier sortie.csv
	 * @throws IOException
	 */
	public void ValiderLaProduction() throws IOException {
		
		f = new FileWriter("Export_production");
		f.append("STOCK AVANT PRODUCTION :\n");
		f.append(this.tout+"\n");
		f.append("Efficacite avant production : "+this.efficacite+"\n\n");
		f.append("-------------------------------------------------\n\n");
		f.append("STOCK APRES PRODUCTION :\n");

		File entree = new File("elements.csv");
		File sortie = new File("sortie.csv");
		BufferedReader br = new BufferedReader(new FileReader(entree));
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		bw.write("Code;Nom;Quantite;unite;achat;vente\n");
		f.append("Code;Nom;Quantite;unite;achat;vente\n");
		Double q;
		Scanner s = new Scanner(entree);
		s.nextLine();
		String data = "";
		while(s.hasNext()) {
			Set<Element> set = hmap.keySet();
			Iterator<Element> it = set.iterator();
			data = s.nextLine();
			String[] values = data.split(";");
			
			q=Double.valueOf(values[2]);
			
			
		
			for (Entry<Element, Double> entry : hmap.entrySet())
				{
					Element test=(Element) it.next();
					if (test.getNom().equals(values[1])){
						if (entry.getValue()!=q) {
							q=entry.getValue();
						}
					}
				}
			values[2]=Double.toString(q);
			bw.write(values[0]+";"+values[1]+";"+values[2]+";"+values[3]+";"+values[4]+";"+values[5]+"\n");
			f.append(values[0]+";"+values[1]+";"+values[2]+";"+values[3]+";"+values[4]+";"+values[5]+"\n");
			bw.flush();
		}
		s.close();
		br.close();
		bw.close();
		
		sortie.renameTo(new File("elements.csv"));
		System.out.println("La production a été validée !!");
		f.append("\nEfficacite après production : " +this.getEfficacite()+"\n");
		f.close();
		
	}
	
	/**
	 * Methode remettant le stock a 0
	 * @throws IOException
	 */
	public void reset() throws IOException {
		
		File sortie = new File("sortie.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		bw.write(this.tout);
		bw.close();
		sortie.renameTo(new File("elements.csv"));
		System.out.println("Le stock a ete reinitialise !");
	}
	
	
}