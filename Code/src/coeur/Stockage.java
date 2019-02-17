package coeur;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


import com.google.common.collect.HashMultimap;
public class Stockage {
	private String code;
	private String nom;
	private double capacite;
	private int QteDispo;
	private HashMap<Element, ArrayList<Double>> cuves = new HashMap<>();
	
	
	
	public Stockage(String code,String nom,double capacite,int QteDispo) {
		this.capacite=capacite;
		this.code=code;
		this.nom=nom;
		this.QteDispo=QteDispo;

		
	}
	
	public void setCapacite(double c) {
		this.capacite=c;
	}
	
	public int ajouter(Element e,double Q) {
		
		Set<Element> set = cuves.keySet();
		boolean existe=false;
		Iterator<Element> it = set.iterator();
	
		for (HashMap.Entry<Element, ArrayList<Double>> entry : cuves.entrySet())
			{
			
			
			Element test=(Element) it.next();
			if(test.getCode().equals(e.getCode())) {
				existe=true;
				for(int i=0;i<entry.getValue().size();i++) {
					if( entry.getValue().get(i)+Q<=this.capacite) {
						entry.getValue().set(i, entry.getValue().get(i)+Q);
						Q=0;
						
					}
					else {
						Q=Q-(this.capacite-entry.getValue().get(i));
						entry.getValue().set(i, this.capacite);				
					}
				}
				if(Q==0) {
					return 0;
				}
			}
			}
		
		if(!existe) {
			ArrayList<Double> arr=new ArrayList<Double>();
			this.cuves.put(e, arr);
			while (Q-this.capacite>0 && this.QteDispo>0) {
				this.cuves.get(e).add(this.capacite);
				Q=Q-this.capacite;
				this.QteDispo--;
				
		}
			if(Q>0) {
				if (this.QteDispo==0) { return -1;}
				this.cuves.get(e).add(Q);
				this.QteDispo--;
				
				Q=0;
				return 0;
			}
		}
		
		if (existe) {
			while (Q-this.capacite>0 && this.QteDispo>0) {
				this.cuves.get(e).add(this.capacite);
				Q=Q-this.capacite;
				this.QteDispo--;
				
			}
			if(Q>0) {
				if (this.QteDispo==0) { return -1;}
				this.cuves.get(e).add(Q);
				this.QteDispo--;
				Q=0;
				return 0;
			}
		}	
		return -1;	
				}			
			
			
	
	public void enlever(Element e,double Q) {
		Set<Element> set = cuves.keySet();
		Iterator<Element> it = set.iterator();

		for (HashMap.Entry<Element, ArrayList<Double>> entry : cuves.entrySet())
			{
		
			Element test=(Element) it.next();
			if(test.getCode().equals(e.getCode())) {
				for(int i=0;i<entry.getValue().size();i++) {
			
				if(entry.getValue().get(i)-Q>=0) {
					entry.getValue().set(i, entry.getValue().get(i)-Q);
					Q=0;
					if( entry.getValue().get(i)==0) {
						cuves.get(e).remove(i);
						this.QteDispo++;
					}
				}
				else {
					Q=Q- entry.getValue().get(i);
					entry.getValue().set(i, (double)0);
					cuves.get(e).remove(i);
					this.QteDispo++;
				}
			}
		}
			}
		
	}
	
	public double getQteDispoAjout(Element e) {
		double QteDispoAjout=0;
		Set<Element> set = cuves.keySet();
		Iterator<Element> it = set.iterator();

		for (HashMap.Entry<Element, ArrayList<Double>> entry : cuves.entrySet())
			{
		
			Element test=(Element) it.next();
			if(test.getCode().equals(e.getCode())) {
				for(int i=0;i<entry.getValue().size();i++) {
					QteDispoAjout=QteDispoAjout+(this.capacite-entry.getValue().get(i));
					System.out.println(test.getCode());
				}
			}
			}
		QteDispoAjout=QteDispoAjout+(this.capacite*this.QteDispo);
		return QteDispoAjout;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String toString() {
		String s="";
		Set<Element> set = cuves.keySet();
		Iterator<Element> it = set.iterator();

		for (HashMap.Entry<Element,ArrayList<Double>> entry : cuves.entrySet())
		{
			
			Element test=(Element) it.next();
			s=s+" | "+test.getNom()+"-->";
			for(int i=0;i<entry.getValue().size();i++) {
				s=s+entry.getValue().get(i)+" ";
			}
		}
		
		return ("Code : "+this.code+" | Nom : "+this.nom+" | Capacité : "+this.capacite+" | Qte dispo: "+this.QteDispo+" | Contenu :"+s);
	}
	
}
