import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.io.*;

public class Stock {
	private final static HashMap<Element,Integer> hmap = new HashMap<>();
	
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
				prixAchat=-1;
			}
			
			if(!values[5].equals("NA")) {
				prixVente = Integer.valueOf(values[5]);
			}
			else {
				prixVente=-1;
			}

			Element e = new Element(values[0],values[1],values[3],prixAchat,prixVente) ;
			
			hmap.put(e, Integer.valueOf(values[2]));
		}
		s.close();
		
	}	
	      
		

	
	public void afficherStock() {
		Set set = hmap.keySet();
		Iterator it = set.iterator();
		
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			System.out.println ("Nom : "+test.getNom()+" | Quantité : "+entry.getValue());
		}
	}
	
	public int getQuantite(String nom) {
		Set set = hmap.keySet();
		Iterator it = set.iterator();
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getNom().equals(nom)){
				return(entry.getValue());
			}
		}
		return 1;
	}
	
	public void ModifierStock(Element e, int quantite) {
		 //=(int)ht.put(2,"BB");
	       
	    //System.out.println("Valeur remplacée : "+val_ret);
	       
	    //System.out.println("Hashtable après modification : "+ht); 
	}
	
	
	
	}
