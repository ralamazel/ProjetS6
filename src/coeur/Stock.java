package coeur;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import gestionfichier.FichierCSVElements;
import gestionfichier.FichierCSVStockage;
import javafx.scene.shape.Path;
import java.lang.*;
import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardCopyOption.*;
public class Stock {
	private HashMap<Element, Double> hmap;
	private FileWriter f;
	private double efficaciteAvant;
	private double efficaciteApres;
	private FichierCSVElements elements;
	private Stockage[] stockages;
	private int indStockage;
	private String tout;
	private HashMap<Element, Double> listeAchat= new HashMap<Element, Double>();
	private boolean validite=true;
	private boolean listeAchats=false;
	private int tempsProduction=0;
	private String erreur;
	/**
	 * Le constructeur de la classe Stock
	 * @throws IOException 
	 */
	public Stock(String cheminFichierElements, String cheminFichierStockage) throws IOException {
		this.elements=new FichierCSVElements(cheminFichierElements);
		this.hmap=elements.Charger();
		
		FichierCSVStockage fi=new FichierCSVStockage(cheminFichierStockage);
		this.stockages=fi.Charger();
		this.indStockage=fi.getInd();
		
		this.efficaciteApres=this.getEfficacite();
		this.tout=this.elements.getTout();
		
		}
	
	public int getTemps() {
		return this.tempsProduction;
	}
	
	public void ajoutTemps(int t) {
		this.tempsProduction=this.tempsProduction+t;
	}
	
	public String getNom(String code) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if(test.getCode().equals(code)) {
				return test.getNom();
			}
		}
		return null;
	}
	
	public void RemplirStockage() {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			double Qte = entry.getValue();
			String stockage = test.getStockage();
			for(int i=0;i<this.indStockage;i++) {
				if(this.stockages[i].getCode().equals(stockage)) {
					this.stockages[i].ajouter(test,Qte);
				}
			}
		}
		System.out.println("Le stock a bien été remplie !");
	}
	
	public void afficherStockage() {
		for(int i=0;i<this.indStockage;i++) {
			System.out.println(this.stockages[i].toString());
		}
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
			System.out.println (test.getNom()+"->"+entry.getValue()+"");
		}

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
	public boolean Ajoutable(String code, Double quantite) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getCode().equals(code)) {
				for(int i=0;i<this.indStockage;i++) {
					if(this.stockages[i].getCode().equals(test.getStockage())) {
						if(this.stockages[i].ajoutable(test,quantite)==true ) {
							return true;
						}
						else {
							//this.resetStockage();
							//System.out.println("Production impossible car on veut ajouter "+quantite+" "+test.getNom()+" alors que la quantité max a ajouter en stock est de "+this.stockages[i].getQteDispoAjout(test) );
							//this.erreur=this.erreur+"Production impossible car on veut ajouter "+quantite+" "+test.getNom()+" alors que la quantité max a ajouter en stock est de "+this.stockages[i].getQteDispoAjout(test);
							
							//this.validite=false;
							return false;
						}
					}		
				}	
			}
		}
		return false;
	}
	/**
	 * Methode permettant d'ajouter une quantite d'element au stock a partir de son code
	 * @param code : code de l'element 
	 * @param quantite : quantite de l'element a ajouter au stock
	 */
	public boolean AjoutStock(String code, Double quantite) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getCode().equals(code)) {
				for(int i=0;i<this.indStockage;i++) {
					if(this.stockages[i].getCode().equals(test.getStockage())) {
						if(this.stockages[i].ajouter(test,quantite)==0 ) {
							entry.setValue(entry.getValue() + quantite);
							return true;
						}
						else {
							this.resetStockage();
							System.out.println("Production impossible car on veut ajouter "+quantite+" "+test.getNom()+" alors que la quantité max a ajouter en stock est de "+this.stockages[i].getQteDispoAjout(test) );
							this.erreur=this.erreur+"Production impossible car on veut ajouter "+quantite+" "+test.getNom()+" alors que la quantité max a ajouter en stock est de "+this.stockages[i].getQteDispoAjout(test);
							
							this.validite=false;
							return false;
						}
					}		
				}	
			}
		}
		return false;
	}
	
	public void resetStockage() {
		FichierCSVStockage fi =new FichierCSVStockage("stockage.csv");
		this.stockages=fi.Charger();
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			double Qte = entry.getValue();
			String stockage = test.getStockage();
			for(int i=0;i<this.indStockage;i++) {
				if(this.stockages[i].getCode().equals(stockage)) {
					this.stockages[i].ajouter(test,Qte);
				}
			}
		}
		System.out.println("Le stockage a bien été réinitialisé");
	}
	/**
	 * methode permettant de retirer du stock une quantite de l'element a partir de son code
	 * @param code : code de l'element a retirer du stock
	 * @param quantite :  quantite de l'element a retirer du stock
	 */
	public int EnleveStock(String code, double quantite) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getCode().equals(code)) {
				//si la production est possible
				if(entry.getValue()-quantite>=0) {
					entry.setValue(entry.getValue() - quantite);
					for(int i=0;i<this.indStockage;i++) {
						if(this.stockages[i].getCode().equals(test.getStockage())) {
							this.stockages[i].enlever(test,quantite);
							return 1;
						}
					}
				}
				//si la production est impossible
				else {
					double a=((entry.getValue()-quantite)*-1);
					System.out.println("Production impossible : il manque "+a+" elements "+test.getNom());
					return 0;
				}
		}

	}
		return -1;
	}
	
	
	public boolean Enlevable(String code, double quantite) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getCode().equals(code)) {
				//si la production est possible
				if(entry.getValue()-quantite>=0) {
					//entry.setValue(entry.getValue() - quantite);
					for(int i=0;i<this.indStockage;i++) {
						if(this.stockages[i].getCode().equals(test.getStockage())) {
							if(this.stockages[i].enlevable(test,quantite)) {
								return true;
							}
						}
					}
				}
				//si la production est impossible
				else {
					double a=((entry.getValue()-quantite)*-1);
					System.out.println("Production impossible : il manque "+a+" elements "+test.getNom());
					return false;
				}
		}

	}
		return false;
	}
	
	public void afficherElement(String nom) {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if (test.getNom().equals(nom)) {
				System.out.println(test.toString()+" Quantité :" +entry.getValue());
				
			}
		}
	}


	
	/**
	 * Permet de verifier si l'element peut-etre produit
	 * @throws IOException 
	 */
	public boolean Examiner() throws IOException {
		f = new FileWriter("Liste d'achats");
		if (this.validite==false) {
			return false;
		}
		Set<Element> set = this.listeAchat.keySet();
		Iterator<Element> it = set.iterator();
		//On regarde si il existe un élément mannquant qui n'aurait pas de prix d'achat
		for (HashMap.Entry<Element, Double> entry : this.listeAchat.entrySet())
		{
			Element test=(Element) it.next();
				if(test.getPrixAchat()==0) {
					System.out.println("Production impossible car l'element "+test.getNom()+ " ne possede pas de prix d'achat");
					this.erreur=this.erreur+"Production impossible car l'element "+test.getNom()+ " ne possede pas de prix d'achat\n";
					return false;
				}
				else {
					f.append(test.getNom()+" : "+entry.getValue()+ " unites a acheter.\n");
					this.listeAchats=true;
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
	public int ValiderLaProduction() throws IOException {
		
		if(this.Examiner()==false) {
			this.tempsProduction=0;
			return -1;
		}
		
		else {

		f = new FileWriter("Export_production");
		f.append("STOCK AVANT PRODUCTION :\n");
		f.append(this.tout+"\n");
		f.append("Efficacite avant production : "+this.efficaciteAvant+"\n\n");
		f.append("-------------------------------------------------\n\n");
		f.append("STOCK APRES PRODUCTION :\n");

		File entree = new File("elementsV2.csv");
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
			bw.write(values[0]+";"+values[1]+";"+values[2]+";"+values[3]+";"+values[4]+";"+values[5]+";"+values[6]+";"+values[7]+"\n");
			f.append(values[0]+";"+values[1]+";"+values[2]+";"+values[3]+";"+values[4]+";"+values[5]+";"+values[6]+";"+values[7]+"\n");
			bw.flush();
		}
		
		if(this.listeAchats==true) {
			File listAchat = new File("Liste d'achats");
			f.append("\nEfficacite apres production : " +this.getEfficacite()+"\n");
			this.efficaciteApres=this.getEfficacite();
			f.append("La production s'effectue en "+this.tempsProduction+" heures\n\n");
			f.append("\nLISTE D'ACHATS :"+"\n");
			Scanner s1 = new Scanner(listAchat);
			while(s1.hasNext()) {
				f.append(s1.nextLine()+"\n");
			}
			
			Set<Element> set = hmap.keySet();
			Iterator<Element> it = set.iterator();
			for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
			{
				Element test=(Element) it.next();
				if(test.getDemande()>0) {
					double QteReel=entry.getValue();
					double demande = test.getDemande();
					double pourcentage;
					if(QteReel>=demande) {
						pourcentage=100;
					}
					else {
						pourcentage =QteReel*100/demande;
					}
					System.out.println(test.getNom()+ " : Demande satisfaite à "+pourcentage+"%");
					f.append(test.getNom()+ " : Demande satisfaite à "+pourcentage+"%");
				}
		
			}

			
			
			s.close();
			br.close();
			bw.close();
			sortie.renameTo(entree);
			System.out.println("La production a ete valide !!");
			
			f.close();
			s1.close();
			this.calculerDemande();
			this.tempsProduction=0;
			return 0;
			
		}
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if(test.getDemande()>0) {
				double QteReel=entry.getValue();
				double demande = test.getDemande();
				double pourcentage;
				if(QteReel>=demande) {
					pourcentage=100;
				}
				else {
					pourcentage =QteReel*100/demande;
				}
				f.append(test.getNom()+ " : Demande satisfaite à "+pourcentage+"%");
			}
	
		}
		
		
		s.close();
		br.close();
		bw.close();
		
		
		
		sortie.renameTo(entree);
		System.out.println("La production a ete valide !!");
		f.append("\nEfficacite apres production : " +this.getEfficacite()+"\n\n");
		f.append("La production s'effectue en "+this.tempsProduction+" heures\n\n");
		f.close();
		this.calculerDemande();
		this.tempsProduction=0;
		return 1;
		}
	}
	
	
	public void calculerDemande() {
		Set<Element> set = hmap.keySet();
		Iterator<Element> it = set.iterator();
		for (HashMap.Entry<Element, Double> entry : hmap.entrySet())
		{
			Element test=(Element) it.next();
			if(test.getDemande()>0) {
				double QteReel=entry.getValue();
				double demande = test.getDemande();
				double pourcentage;
				if(QteReel>=demande) {
					pourcentage=100;
				}
				else {
					pourcentage =QteReel*100/demande;
				}
				System.out.println(test.getNom()+ " : Demande satisfaite à "+pourcentage+"%");
			}
	
		}
	}
	
	/**
	 * Methode remettant le stock a 0
	 * @throws IOException
	 */
	public void reset() throws IOException {
		
		File sortie = new File("sortie.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		bw.write("Code;Nom;Quantite;unite;achat;vente;stockage;Demande\r\n" + 
				"E001;Sucre;500;kg;1;NA;cp;0\r\n" + 
				"E002;farine;1500;kg;1;NA;cp;0\r\n" + 
				"E003;farine complete;0;kg;1;NA;cp;0\r\n" + 
				"E004;blanc oeuf;200;litre;2;NA;cl;0\r\n" + 
				"E005;jaune oeuf;400;litre;2;NA;cl;0\r\n" + 
				"E006;beurre;2500;kg;3;NA;pr;0\r\n" + 
				"E007;margarine;0;kg;2;NA;pr;0\r\n" + 
				"E008;huile palme;5000;litre;1;NA;p;0\r\n" + 
				"E009;huile colza;1500;litre;2;NA;p;0\r\n" + 
				"E010;poudre a lever;50;kg;2;NA;p;0\r\n" + 
				"E011;beurre cacao;800;kg;3;NA;p;0\r\n" + 
				"E012;pate cacao;150;kg;12;NA;cp;0\r\n" + 
				"E013;proteine de lait;0;kg;1;NA;cp;0\r\n" + 
				"E014;lait en poudre;500;kg;1;NA;cp;0\r\n" + 
				"E015;emulsifiant;10;litre;3;NA;cl;0\r\n" + 
				"E016;levure;89;unite;3;NA;cp;0\r\n" + 
				"E017;confiture abricot;50;litre;2;NA;clr;0\r\n" + 
				"E018;noix;50;kg;5;NA;p;0\r\n" + 
				"E019;Chocolat 30�%;20;litre;10;8;cl;0\r\n" + 
				"E020;Chocolat 40�%;12;litre;12;10;cl;0\r\n" + 
				"E021;Chocolat 50�%;30;litre;NA;16;cl;0\r\n" + 
				"E022;Pate biscuit Q1;0;litre;NA;NA;clr;0\r\n" + 
				"E023;Pate biscuit Q2;0;litre;NA;NA;clr;0\r\n" + 
				"E024;Pate biscuit Q3;0;litre;NA;NA;clr;0\r\n" + 
				"E025;Gateau marque A;0;carton;NA;10;p;200\r\n" + 
				"E026;Gateau marque B;0;carton;NA;8;p;300\r\n" + 
				"E027;Gateau marque C;0;carton;NA;7;p;250\r\n" + 
				"E028;Pate lev�e huile;0;kg;NA;NA;cb;0\r\n" + 
				"E029;Pate lev�e beurre;0;kg;NA;NA;cb;0\r\n" + 
				"E030;Brioche;10;carton;NA;14;p;300\r\n" + 
				"E031;Brioche beurre;0;carton;NA;16;p;100\r\n" + 
				"E032;Pain chocolat A;0;carton;NA;14;p;50\r\n" + 
				"E033;Pain chocolat B;0;carton;NA;12;p;75\r\n" + 
				"E034;Biscuit marque A;0;carton;NA;8;p;400\r\n" + 
				"E035;Biscuit marque B et C;0;carton;NA;7;p;750\r\n" + 
				"E036;Pate crepes;25;litre;9;NA;cb;0\r\n" + 
				"E037;Crepes natures;0;carton;NA;7;p;175\r\n" + 
				"E038;Crepes fourrees choc;0;carton;NA;9;p;100\r\n" + 
				"E039;Crepes fourres abricot;0;carton;NA;8;p;75\r\n" + 
				"E040;Brownies marque A;0;carton;NA;10;p;250\r\n" + 
				"E041;Brownies marque B;0;carton;NA;8;p;275\r\n" + 
				"E042;Cookies Choc marque A;0;carton;NA;9;p;300\r\n" + 
				"E043;Cookies Choc marque B;0;carton;NA;8;p;400\r\n" + 
				"E044;Cookies Choc/Noix marque A;0;carton;NA;9;p;150\r\n" + 
				"E045;Cookies Choc/Noix marque B;0;carton;NA;8;p;300\r\n" + 
				"E046;Pate Madeleines Q1;0;litre;NA;NA;cb;0\r\n" + 
				"E047;Pate Madeleines Q2;0;litre;NA;NA;cb;0\r\n" + 
				"E048;Madeleines marque A;0;carton;NA;8;p;200\r\n" + 
				"E049;Madeleines marque B;0;carton;NA;7;p;150\r\n" + 
				"E050;Madeleines Choc;0;carton;NA;8;p;100\r\n" + 
				"E051;Poudre a lever;28;kg;2;NA;cp;0");
		bw.close();
		sortie.renameTo(new File("elementsV2.csv"));
		System.out.println("Le stock a ete reinitialise !");
	}
	
	public String getErreur() {
		return this.erreur;
	}
	
	public double getEfficaciteAvant() {
		return this.efficaciteAvant;
	}
	
	public double getEfficaciteApres() {
		return this.efficaciteApres;
	}
	
	
}