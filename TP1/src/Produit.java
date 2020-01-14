
public class Produit {

	private String nom;
	private int prix;
	private int nbrJoursAvantPeremption;
	
	public Produit(String nom, int prix, int nbrJoursAvantPeremption) {
		this.nom = nom;
		this.prix = prix;
		this.nbrJoursAvantPeremption = nbrJoursAvantPeremption;
	}
	
	public Produit(Produit produit) {
		this.nom = produit.getNom();
		this.prix = produit.getPrix();
		this.nbrJoursAvantPeremption = produit.getNbrJoursAvantPeremption();
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public int getNbrJoursAvantPeremption() {
		return nbrJoursAvantPeremption;
	}

	public void setNbrJoursAvantPeremption(int nbrJoursAvantPeremption) {
		this.nbrJoursAvantPeremption = nbrJoursAvantPeremption;
	}
	
}
