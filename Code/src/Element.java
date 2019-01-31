
public  class Element {
	private String code;
	private String nom;
	private String unite;
	private int prixAchat;
	private int prixVente;
	
	/**
	 * @param code : le code de l'�l�ment
	 * @param nom : le nom de l'�l�ment
	 * @param unite : l'unit� de l'�l�ment ( pi�ces, kilo ...)
	 * @param prixAchat : le prix d'achat d'un �l�ment
	 * @param prixVente : le prix de vente d'un �l�ment
	 */
	public Element(String code,String nom, String unite, int prixAchat, int prixVente) {
		this.code=code;
		this.nom=nom;
		this.unite=unite;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
	}
	
	
	public String getCode() {
		return this.code;
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