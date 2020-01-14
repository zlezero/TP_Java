import java.util.Scanner;

public class Entrepot {

	private PileEntrepot ensembleProduits;
	private int nbrProduitsPerimes;
	
	public Entrepot(int tailleEntrepot) {
		ensembleProduits = new PileEntrepot(tailleEntrepot);
		nbrProduitsPerimes = 0;
	}
	
	public Entrepot(PileEntrepot ensembleProduits) {
		this.ensembleProduits = ensembleProduits;
		nbrProduitsPerimes = ensembleProduits.nbrElementsPerimes();
	}
	
	public void construitEntrepot() {
		
		String nom = "";
		int prix = 0;
		int nbrJoursAvantPremption = 0;
	
		int nbrElements = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("Entrez le nombre de produits à entrer (< " + ensembleProduits.getNbrElemMax() + ") : ");	
			nbrElements = scanner.nextInt();
		} while (nbrElements < 0 || nbrElements > ensembleProduits.getNbrElemMax());	

		for (int i = 0; i < nbrElements; i++) {
			
			System.out.println("\n== Produit " + (i+1) + " ==");
			System.out.print("Entrez le nom : ");
			
			scanner.nextLine();
			nom = scanner.nextLine();

			System.out.print("Entrez le prix : ");
			
			prix = scanner.nextInt();

			System.out.print("Entrez le nombre de jours avant péremption : ");
			
			nbrJoursAvantPremption = scanner.nextInt();

			ensembleProduits.empile(new Produit(nom, prix, nbrJoursAvantPremption));
			
			if (nbrJoursAvantPremption < 0) {
				nbrProduitsPerimes += 1;
			}
			
		}
		
		scanner.close();
		
	}
	
	public void construitEntrepotClavier() {
		
		String nom = "";
		int prix = 0;
		int nbrJoursAvantPremption = 0;
		
		int nbrElements = 0;
		
		do {
			System.out.print("Entrez le nombre de produits à entrer (< " + ensembleProduits.getNbrElemMax() + ") : ");	
			nbrElements = Clavier.lireInt();
		} while (nbrElements < 0 || nbrElements > ensembleProduits.getNbrElemMax());	

		for (int i = 0; i < nbrElements; i++) {
			
			System.out.println("\n== Produit " + (i+1) + " ==");
			System.out.print("Entrez le nom : ");
			
			nom = Clavier.lireString();
			
			System.out.print("Entrez le prix : ");
			
			prix = Clavier.lireInt();
			
			System.out.print("Entrez le nombre de jours avant péremption : ");
			
			nbrJoursAvantPremption = Clavier.lireInt();
			
			ensembleProduits.empile(new Produit(nom, prix, nbrJoursAvantPremption));
			
			if (nbrJoursAvantPremption < 0) {
				nbrProduitsPerimes += 1;
			}
			
		}
		
	}
	
	public void trie() {
		
		PileEntrepot pileB = new PileEntrepot(ensembleProduits.getNbrElemMax());
		PileEntrepot pileC = new PileEntrepot(ensembleProduits.getNbrElemMax());

		while (!ensembleProduits.est_vide()) {
			
			if (pileB.est_vide() || ensembleProduits.sommet().getNbrJoursAvantPeremption() < pileB.sommet().getNbrJoursAvantPeremption()) {
				
				pileB.empile(ensembleProduits.depile());
				
				while(!pileC.est_vide()) {
					pileB.empile(pileC.depile());
				}
				
			}
			else {
				pileC.empile(pileB.depile());
			}
			
		}
		
		ensembleProduits = pileB;
		
	}
	
	public int suppressionAvecTri() {
		
		int somme = 0;
		
		trie();

		while (ensembleProduits.sommet().getNbrJoursAvantPeremption() < 0) {
			somme += ensembleProduits.depile().getPrix();
		}
		
		nbrProduitsPerimes = 0;
		
		return somme;
		
	}
	
	public int suppression() {
		
		int somme = 0;
		
		PileEntrepot pileB = new PileEntrepot(ensembleProduits.getNbrElemMax());
		
		while (!ensembleProduits.est_vide()) {
			
			if (ensembleProduits.sommet().getNbrJoursAvantPeremption() < 0)
				somme +=  ensembleProduits.depile().getPrix();	
			else
				pileB.empile(ensembleProduits.depile());
			
		}
		
		while (!pileB.est_vide()) {
			ensembleProduits.empile(pileB.depile());
		}
		
		nbrProduitsPerimes = 0;

		return somme;
		
	}
	
	public Entrepot union(Entrepot entrepot2) {
		
		PileEntrepot pileTempA = new PileEntrepot(ensembleProduits);
		PileEntrepot pileTempB = new PileEntrepot(entrepot2.ensembleProduits);
		PileEntrepot pileRetour = new PileEntrepot(ensembleProduits.getNbrElemMax() + entrepot2.ensembleProduits.getNbrElemMax());
		PileEntrepot pileRetourInversee = new PileEntrepot(ensembleProduits.getNbrElemMax() + entrepot2.ensembleProduits.getNbrElemMax());		

		while (!pileTempA.est_vide() && !pileTempB.est_vide()) {
			
			if (pileTempA.sommet().getNbrJoursAvantPeremption() == pileTempB.sommet().getNbrJoursAvantPeremption() && pileTempA.sommet().getNom() == pileTempB.sommet().getNom() && pileTempA.sommet().getPrix() == pileTempB.sommet().getPrix()) {
				pileRetour.empile(pileTempA.depile());
				pileTempB.depile();
			}
			else if (pileTempA.sommet().getNbrJoursAvantPeremption() < pileTempB.sommet().getNbrJoursAvantPeremption()) {
				pileRetour.empile(pileTempA.depile());
			}
			else {
				pileRetour.empile(pileTempB.depile());
			}
			
		}
		
		while (!pileRetour.est_vide()) {
			pileRetourInversee.empile(new Produit(pileRetour.depile()));
		}
				
		Entrepot entrepotRetour = new Entrepot(pileRetourInversee);
		
		return entrepotRetour;
		
	}
	
	public Entrepot intersection(Entrepot entrepot2) {
		
		PileEntrepot pileTempA = new PileEntrepot(ensembleProduits);
		PileEntrepot pileTempB = new PileEntrepot(entrepot2.ensembleProduits);
		PileEntrepot pileRetour = new PileEntrepot(ensembleProduits.getNbrElemMax() + entrepot2.ensembleProduits.getNbrElemMax());		
		PileEntrepot pileRetourInversee = new PileEntrepot(ensembleProduits.getNbrElemMax() + entrepot2.ensembleProduits.getNbrElemMax());		
				
		while (!pileTempA.est_vide() && !pileTempB.est_vide()) {
			
			if (pileTempA.sommet().getNbrJoursAvantPeremption() > pileTempB.sommet().getNbrJoursAvantPeremption()) {		
				pileTempB.depile();
			}
			else if (pileTempA.sommet().getNbrJoursAvantPeremption() < pileTempB.sommet().getNbrJoursAvantPeremption()) {
				pileTempA.depile();
			}
			else if (pileTempA.sommet().getNbrJoursAvantPeremption() == pileTempB.sommet().getNbrJoursAvantPeremption() && pileTempA.sommet().getNom() == pileTempB.sommet().getNom() && pileTempA.sommet().getPrix() == pileTempB.sommet().getPrix()) {
				pileRetour.empile(pileTempA.depile());
				pileTempB.depile();
			}
			else {
				pileTempA.depile();
				pileTempB.depile();
			}
			
		}
		
		while (!pileRetour.est_vide()) {
			pileRetourInversee.empile(new Produit(pileRetour.depile()));
		}
				
		Entrepot entrepotRetour = new Entrepot(pileRetourInversee);
		
		return entrepotRetour;
		
	}

	public PileEntrepot getEnsembleProduits() {
		return ensembleProduits;
	}
	
	public void setEnsembleProduits(PileEntrepot ensembleProduits) {
		this.ensembleProduits = ensembleProduits;
	}
	
	public int getNbrProduitsPerimes() {
		return nbrProduitsPerimes;
	}
	
	public void setNbrProduitsPerimes(int nbrProduitsPerimes) {
		this.nbrProduitsPerimes = nbrProduitsPerimes;
	}
	
	public static void main(String[] args) {
		
		//On construit le premier entrepot
		Entrepot entrepot = new Entrepot(10);
		
		//entrepot.construitEntrepot();
		
		String[] nomProduits = {"P1", "P2", "P3", "P4", "P5"};
		int[] prixProduits = {10, 20, 30, 40, 50};
		int[] datePeremptionProduits = {-10, -20, 10, 20, -15};
		
		for (int i = 0 ; i < nomProduits.length; i++) {
			entrepot.ensembleProduits.empile(new Produit(nomProduits[i], prixProduits[i], datePeremptionProduits[i]));
		}
		
		//On construit le deuxième entrepot
		Entrepot entrepot2 = new Entrepot(10);
		
		String[] nomProduits2 = {"P1", "P2", "P3", "P4", "P5"};
		int[] prixProduits2 = {10, 20, 70, 80, 90};
		int[] datePeremptionProduits2 = {-10, -20, 10, 20, -15};
		
		for (int i = 0 ; i < nomProduits.length; i++) {
			entrepot2.ensembleProduits.empile(new Produit(nomProduits2[i], prixProduits2[i], datePeremptionProduits2[i]));
		}
		
		entrepot.trie();
		entrepot2.trie();
		
		System.out.println("\n== On fait l'union entre l'entrepôt 1 et 2 ==\n");
		
		entrepot.union(entrepot2).ensembleProduits.affiche();
		
		System.out.println("\n== On fait l'intersection entre l'entrepôt 1 et 2 ==\n");
		
		entrepot.intersection(entrepot2).ensembleProduits.affiche();
		
		System.out.println("\n== On affiche l'entrepôt ==\n");
		
		entrepot.getEnsembleProduits().affiche();
		
		System.out.println("\n== On supprime les éléments périmés ==\n");
		
		System.out.println("Somme perdue : " + entrepot.suppression());
		
		entrepot.ensembleProduits.affiche();
		
		System.out.println("\n== On trie l'entrepôt ==\n");
		
		entrepot.trie();
		
		entrepot.ensembleProduits.affiche();
		
	}
	
}
