
public class Tri {
	
	private Pile pileA;
	private Pile pileB;
	private Pile pileC;

	public Tri(Pile pile) {
		pileA = pile;
		pileB = new Pile(pileA.getNbrElement());
		pileC = new Pile(pileA.getNbrElement());
	}
	
	public Pile tri() {
		
		while (!pileA.est_vide()) {
			
			if (pileB.est_vide() || pileA.sommet().getElement() < pileB.sommet().getElement()) {
				
				pileB.empile(pileA.depile());
				
				while(!pileC.est_vide()) {
					pileB.empile(pileC.depile());
				}
				
			}
			else {
				pileC.empile(pileB.depile());
			}
			
		}
		
		return pileB;
		
	}
	
	public static void main(String[] args) {
		
		int[] donneesPile = {4, 3, 2, 5, 8, 2, 6, 9, 3};
		
		Pile pileA = new Pile(donneesPile.length);
		
		for (int i = 0 ; i < donneesPile.length; i++) {
			pileA.empile(new ElementPile(donneesPile[i]));
		}
		
		pileA.affiche();
		
		Tri tri = new Tri(pileA);
		
		System.out.println("\n== Tri de la pile ==\n");
		
		pileA = tri.tri();
		
		pileA.affiche();
		
	}
	
	
}
