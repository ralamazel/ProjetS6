
public  class Element {
	private String code;
	private String nom;
	private String unite;
	private int prixAchat;
	private int prixVente;
	
	public Element(String code,String nom, String unite, int prixAchat, int prixVente) {
		this.code=code;
		this.nom=nom;
		this.unite=unite;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
	}

	 public String getNom() {
		 return this.nom;
	 }
	 
	 public int getPrixAchat() {
		 return this.prixAchat;
	 }
	 
	 public int getPrixVente() {
		 return this.prixVente;
	 }
	 
	 public String getUnite() {
		 return this.unite;
	 }
	
	

}
