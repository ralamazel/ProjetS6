package coeur;

public class Stockage {
	private String code;
	private String nom;
	private double capacite;
	private int QteDispo;
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
	
	public boolean ajouter(double Q) {
		if(this.QteEnStock+Q>this.CapaciteMax) {
			return false;
		}
		else {
			this.QteEnStock=this.QteEnStock+Q;
			System.out.println("On a ajouté ");
			return true;
		}
		
	}
	
	public void enlever(double Q) {
		this.QteEnStock=this.QteEnStock-Q;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String toString() {
		return "Code : "+this.code+" | Nom : "+this.nom+" | Capacité : "+this.capacite+" | Quantité disponible : "+this.QteDispo+" | Capacité maximale :"+this.CapaciteMax+" | Quantité en stock :"+this.QteEnStock;
	}
}
