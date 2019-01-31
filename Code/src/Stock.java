import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Stock {
	private final static HashMap<Element, Double> hmap = new HashMap<>();
	
	/**
	 * Le constructeur de la classe Stock
	 * @throws FileNotFoundException
	 */
	public Stock() throws FileNotFoundException {
		String fileName = "elements.csv";
		File file = new File(fileName);
		int prixVente,prixAchat;
		
		Scanner s = new Scanner(file);
		s.nextLine();
		
		String data = "";
		while(s.hasNext()) {
			
			data = s.nextLine();
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
		
	}	
	      
		

	
	/**
	 * M�thode permettant d'afficher le stock
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
	 * @param nom : nom de l'�l�ment dont on cherche la quantit�
	 * @return la quantit� de l'�l�ment ou 1 si le nom de l'�l�ment n'est pas dans la hashmap
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
	 * M�thode permettant d'ajouter une quantit� d'�l�ment au stock � partir de son code
	 * @param code : code de l'�l�ment 
	 * @param quantite : quantit� de l'�l�ment � ajouter au stock
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
	 * m�thode permettant de retirer du stock une quantit� de l'�l�ment � partir de son code
	 * @param code : code de l'�l�ment � retirer du stock
	 * @param quantite :  quantit� de l'�l�ment � retirer du stock
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
	 * Permet de v�rifier si l'�l�ment peut-�tre produit
	 */
	public void Examiner() {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if(entry.getValue()<0) {
				
				if(test.getPrixAchat()==0) {
					System.out.println("Production impossible car l'element "+test.getNom()+ " ne possede pas de prix d'achat");
					return;
				}
				
			}
		}
		System.out.println("Production possible");
	}
	
	/**
	 * M�thode calculant l'efficacit� de la production
	 */
	public void efficacite() {
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
		System.out.println("L'efficacite de la production est de "+eff+" euros");
	}
	
	/**
	 * Methode permettant de valider la production effectu�e et de l'inscrire dans le fichier sortie.csv
	 * @throws IOException
	 */
	public void ValiderLaProduction() throws IOException {
		
	
		File entree = new File("elements.csv");
		File sortie = new File("sortie.csv");
		BufferedReader br = new BufferedReader(new FileReader(entree));
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		bw.write("Code;Nom;Quantite;unite;achat;vente\n");
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
			bw.flush();
		}
		s.close();
		br.close();
		bw.close();
		
		sortie.renameTo(new File("elements.csv"));
	}
	
	/**
	 * M�thode remettant le stock � 0
	 * @throws IOException
	 */
	public void reset() throws IOException {
		
		File sortie = new File("sortie.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		bw.write("Code;Nom;Quantite;unite;achat;vente\n");
		bw.write("E001;Circuit principal;200;pieces;50;20\n");
		bw.write("E002;Plastique;500;kilogrammes;3;NA\n");
		bw.write("E003;Plaques aluminium;100;pieces;20;10\n");
		bw.write("E004;Servomoteurs;250;pieces;15;10\n");
		bw.write("E005;Propulsions;0;pieces;NA;15\n");
		bw.write("E006;Coques;0;pieces;NA;NA\n");
		bw.write("E007;Drones;0;pieces;NA;150\n");
		
		bw.close();
		sortie.renameTo(new File("elements.csv"));
		System.out.println("Le stock a ete reinitialise !");
	}
	
}