package coeur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Fabrication {
	private HashMap<Chaine,Integer> chaines;
	
	private int temps;
	private int Somme_niveauAct;
	private String listeElementConsommer="";
	private String listeElementFabriquer="";

	public Fabrication(HashMap<Chaine,Integer> chaines, Stock s) {
		this.chaines=chaines;
		this.temps=0;
		for (HashMap.Entry<Chaine, Integer> entry : chaines.entrySet())
		{
			this.Somme_niveauAct=this.Somme_niveauAct+entry.getValue();
		}
		
		Set<Chaine> set = this.chaines.keySet();
		Iterator<Chaine> it = set.iterator();
		for (HashMap.Entry<Chaine, Integer> entry : chaines.entrySet())
		{
			Chaine test =it.next();
			this.listeElementFabriquer+=test.getnomElementACreer()+"-->"+entry.getValue()*test.getQteElementACreer()+"\n";
			Set<String> setIn = test.getInput().keySet();
			Iterator<String> itIn = setIn.iterator();
			for (Entry<String, Double> entry2 : test.getInput().entrySet())
			{
				
				
				this.listeElementConsommer+=s.getNom(entry2.getKey())+"-->"+entry2.getValue()*entry.getValue()+"\n";
			}
			
			
		}
	}
	
	public boolean calculerProduction(Stock s) {
	
		while(this.Somme_niveauAct>0 && this.temps<=60) {
			System.out.println("-------"+this.temps+"-------");
	
				Set<Chaine> set = this.chaines.keySet();
				Iterator<Chaine> it = set.iterator();
				//On parcourt les chaines de production
				for (HashMap.Entry<Chaine, Integer> entry : chaines.entrySet())
				{
					Chaine test=(Chaine) it.next();

					//Si le niveau d'activation de la chaine est >0
					if(entry.getValue()>0) {
						//On fait fabriquer la chaine avec un niveau d'activation de 1
						if(test.fabricable(1, s)){
							if(test.tempsRestant==-1) {
								System.out.println(test.getnomElementACreer()+" met tempsRestant à "+test.getTemps());
								test.tempsRestant=test.getTemps();
							}
							
							if(test.tempsRestant==0) {
								test.fabriquer(1, s);
								
								System.out.println("On fabrique "+test.getQteElementACreer()+" "+test.getnomElementACreer());
								entry.setValue(entry.getValue()-1);
								this.Somme_niveauAct--;
								test.tempsRestant=test.getTemps();
							}
							
							else {
								test.tempsRestant--;
								if(test.tempsRestant==0) {
									test.fabriquer(1, s);
									System.out.println("On fabrique "+test.getQteElementACreer()+" "+test.getnomElementACreer());
									entry.setValue(entry.getValue()-1);
									this.Somme_niveauAct--;
									test.tempsRestant=test.getTemps();
								}
							}
							
						}
						else {
							System.out.println("On ne peut pas encore fabriquer "+test.getQteElementACreer()+" "+test.getnomElementACreer());
						}
						
					}
					
				}
				
				this.temps++;
					
		}
			if(this.temps<=60 && this.Somme_niveauAct==0) {
				
				System.out.println("Production possible en "+this.temps+" heures");
				return true;
			}
			else {
				if(this.temps>=60) {
					System.out.println("Temps d'activité hebdomadaire atteint : arret de la production");
				}
				else {
					System.out.println("Impossible de produire la Qte Demandée ");
				}
			return false;
		}


	}
	
	public int getTemps() {
		return this.temps;
	}

	public String getListeElementConsommer() {
		return listeElementConsommer;
	}


	public String getListeElementFabriquer() {
		return listeElementFabriquer;
	}


	
	
	
	
	
	
	
	
}
