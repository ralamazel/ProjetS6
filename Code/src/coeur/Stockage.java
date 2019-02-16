package coeur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Stockage {
	private String code;
	private String nom;
	private double capacite;
	private int QteDispo;
	private HashMap<Element, Double> cuves = new HashMap<>();
	private MultiValuedMap map = new MultiValuedHashMap();
	private double CapaciteMax;
	private double QteEnStock;
	
	public Stockage(String code,String nom,double capacite,int QteDispo) {
		this.capacite=capacite;
		this.code=code;
		this.nom=nom;
		this.QteDispo=QteDispo;
		this.CapaciteMax=this.QteDispo*this.capacite;
		this.QteEnStock=0;
		
	}
	
	public void setCapacite(double c) {
		this.capacite=c;
	}
	
	public int ajouter(Element e,double Q) {
		
		Set<Element> set = cuves.keySet();
		Iterator<Element> it = set.iterator();

		for (HashMap.Entry<Element, Double> entry : cuves.entrySet())
		{
			Element test=(Element) it.next();
			if(test.getCode().equals(e.getCode())) {
				if(entry.getValue()+Q<=this.capacite) {
					entry.setValue(entry.getValue()+Q);
					Q=0;
					
				}
				else {
					Q=Q-(this.capacite-entry.getValue());
					entry.setValue(this.capacite);
					
				}
			}
		}
		if(Q==0) {
			return 0;
		}
		else {
			while(Q-this.capacite>0 && this.QteDispo>0) {
				cuves.put(e, this.capacite);
				this.QteDispo--;
				Q=Q-this.capacite;
			}
			if(this.QteDispo>0 && this.QteDispo>0) {
				cuves.put(e, Q);
				System.out.println("ZRGREGREGRGRGRZ");
				this.QteDispo--;
				Q=0;
			}
		}
		if (Q==0) {
			return 0;
		}
		return -1;
	}
	
	public void enlever(Element e,double Q) {
		this.QteEnStock=this.QteEnStock-Q;
		Set<Element> set = cuves.keySet();
		Iterator<Element> it = set.iterator();

		for (HashMap.Entry<Element, Double> entry : cuves.entrySet())
		{
			Element test=(Element) it.next();
			if(test.getCode().equals(e.getCode())) {
				if(entry.getValue()-Q>=0) {
					entry.setValue(entry.getValue()-Q);
					Q=0;
					if(entry.getValue()==0) {
						cuves.remove(test);
						this.QteDispo++;
					}
				}
				else {
					Q=Q-entry.getValue();
					entry.setValue((double) 0);
					cuves.remove(test);
					this.QteDispo++;
				}
			}
		}
		
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String toString() {
		String s="";
		Set<Element> set = cuves.keySet();
		Iterator<Element> it = set.iterator();

		for (HashMap.Entry<Element, Double> entry : cuves.entrySet())
		{
			Element test=(Element) it.next();
			s=s+" | "+test.getNom()+"-->"+entry.getValue();
		}
		
		return ("Code : "+this.code+" | Nom : "+this.nom+" | Capacité : "+this.capacite+" | Qte dispo: "+this.QteDispo+" | Contenu :"+s);
	}
	
	public double getQuantiteDispo() {
		return this.CapaciteMax-this.QteEnStock;
	}
}
