import java.util.Arrays;

public class PileEntrepot {
	
	private Produit[] pile;
	private int nbrElement;
	
	public PileEntrepot(int taillePille) {
		pile = new Produit[taillePille];
		nbrElement = -1;
	}
	
	public PileEntrepot(PileEntrepot pile) {
		this.pile = Arrays.copyOf(pile.pile, pile.pile.length);
		this.nbrElement = pile.nbrElement;
	}
	
	public boolean est_vide() {
		return nbrElement == -1;
	}
	
	public boolean empile(Produit element) {
		
		if ( nbrElement + 1 < pile.length) {
			
			nbrElement++;
			pile[nbrElement] = element;
			return true;
			
		}
		else {
			return false;
		}

	}
	
	public Produit depile() {
		
		if (!est_vide()) {
			nbrElement--;
			return pile[nbrElement+1];	
		}
		else {
			return null;
		}

	}
	
	public Produit sommet() {
		if (!est_vide())
			return pile[nbrElement];
		else
			return null;
	}
	
	public void affiche() {
		
		if (!est_vide()) {
			for (int i = nbrElement; i >= 0; i--) {
				System.out.println("[" + i + "] Nom = " + pile[i].getNom() + " / Prix = " + pile[i].getPrix() + " / Nbr de jours avant péremption : " + pile[i].getNbrJoursAvantPeremption());
			}
		}
		
	}
	
	public int nbrElementsPerimes() {
		
		int nbrElementsPerimes = 0;
		
		for (int i = 0; i < nbrElement; i++) {
			if (pile[nbrElement].getNbrJoursAvantPeremption() < 0) {
				nbrElementsPerimes++;
			}
		}
		
		return nbrElementsPerimes;
		
	}
	
	public int getNbrElement() {
		return nbrElement;
	}
	
	public int getNbrElemMax() {
		return pile.length;
	}

}
