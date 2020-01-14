
public class Test_Pile {
	
	public static void main(String[] args) {
		
		Pile pile = new Pile(10);
		
		System.out.println("On empile trois éléments sur la pile.\n");
		
		pile.empile(new ElementPile(10));
		pile.empile(new ElementPile(20));
		pile.empile(new ElementPile(30));
		
		pile.affiche();
		
		System.out.println("\nL'élément au sommet est : " + pile.sommet().getElement()+"\n");
		
		System.out.println("== On dépile la pile d'un élément ==\n");

		pile.depile();
		
		pile.affiche();
		
		System.out.println("\nL'élément au sommet est : " + pile.sommet().getElement()+"\n");
		
		System.out.println("== On dépile la pile d'un élément ==\n");

		pile.depile();

		pile.affiche();
		
		System.out.println("\nL'élément au sommet est : " + pile.sommet().getElement()+"\n");

		System.out.println("== On dépile la pile d'un élément ==\n");

		if (pile.depile() == null) {
			System.out.println("On essaye de dépiler mais la pile est vide !");
		}
		
		System.out.println("On empile 100 sur la pile !\n");
		
		pile.empile(new ElementPile(100));
		
		pile.affiche();
		
		System.out.println("On remplit la pile entièrement !\n");

		for (int i = 0; i < 10; i++) {
			pile.empile(new ElementPile(i * 100));
		}
		
		pile.affiche();
		
		System.out.println("\nSi on essaye de rajouter un élément ça ne marche pas car la pile est pleine !\n");

		pile.empile(new ElementPile(1000));
		
		pile.affiche();

	}
	
}
