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
				prixAchat=0;
			}
			
			if(!values[5].equals("NA")) {
				prixVente = Integer.valueOf(values[5]);
			}
			else {
				prixVente=0;
			}

			Element e = new Element(values[0],values[1],values[3],prixAchat,prixVente) ;
			
			hmap.put(e, Integer.valueOf(values[2]));
		}
		s.close();
		
	}	
	      
		

	
	public void afficherStock() {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			System.out.println ("Nom : "+test.getNom()+" | Quantité : "+entry.getValue());
		}
		System.out.println ();
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
	
	public void AjoutStock(Element e, int quantite) {
		Set set = hmap.keySet();
		Iterator it = set.iterator();
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getNom().equals(e.getNom())) {
				entry.setValue(entry.getValue() + quantite);
			}
			
		}

	}
	
	public void EnleveStock(Element e, int quantite) {
		Set set = hmap.keySet();
		Iterator it = set.iterator();
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getNom().equals(e.getNom())) {
				entry.setValue(entry.getValue() - quantite);
			}
			
		}

	}
	
	public void ChaineCoque(int n) {
		this.EnleveStock(new Plastique(), 5*n);
		this.EnleveStock(new PlaqueAlu(), 1*n);
		this.AjoutStock(new Coque(), 10*n);
	}
	
	public void ChaineDrone(int n) {
		this.EnleveStock(new Coque(), 1*n);
		this.EnleveStock(new Propulsion(), 24*n);
		this.EnleveStock(new CircuitPrincipal(), 8*n);
		this.AjoutStock(new Drone(), 4*n);
	}
	
	public void Examiner() {
		Set set = hmap.keySet();
		Iterator it = set.iterator();
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if(entry.getValue()<0) {
				
				if(test.getPrixAchat()==0) {
					System.out.println("Production impossible car l'élément "+test.getNom()+ " ne possède pas de prix d'achat");
					return;
				}
				
			}
		}
		System.out.println("Production possible");
	}
	
	public void efficacite() {
		int eff, valeurVenteStock=0, valeurAchat=0;
		Set set = hmap.keySet();
		Iterator it = set.iterator();
		
		for (HashMap.Entry<Element, Integer> entry : hmap.entrySet())
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
		System.out.println("L'efficacité de la production est de "+eff+" euros");
	}
	
	}
