
public class Pile {
	
	private ElementPile[] pile;
	private int nbrElement; 
	
	public Pile(int taillePille) {
		pile = new ElementPile[taillePille];
		nbrElement = -1;
	}
	
	//Une pile vide est représentée avec un nombre d'élément égal à -1
	public boolean est_vide() {
		return nbrElement == -1;
	}
	
	public boolean empile(ElementPile element) {
		
		if ( nbrElement + 1 < pile.length) {
			
			nbrElement++;
			pile[nbrElement] = element;
			return true;
			
		}
		else {
			return false;
		}

	}
	
	public ElementPile depile() {
		
		if (!est_vide()) {
			nbrElement--;
			return pile[nbrElement+1];	
		}
		else {
			return null;
		}

	}
	
	public ElementPile sommet() {
		if (!est_vide())
			return pile[nbrElement];
		else
			return null;
	}
	
	public void affiche() {
		
		if (!est_vide()) {
			for (int i = nbrElement; i >= 0; i--) {
				System.out.println("[" + i + "] = " + pile[i].getElement());
			}
		}
		
	}
	
	public int getNbrElement() {
		return nbrElement;
	}

}
