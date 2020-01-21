
public class TestRobot {
	
	
	public static void main(String[] args) {
	
		System.out.println("=== TEST DU MONDE ===\n");
		
		Monde monde = new Monde(10, 10);
		
		System.out.println("=== On affiche le monde ===");
		
		System.out.println(monde.toString());
		
		System.out.println("=== On met un papier gras en position (5,5) ===");

		monde.metPapierGras(5, 5);
		
		System.out.println(monde.toString());

		System.out.println("(5,5) est sale : " + monde.estSale(5, 5) + " / (6,6) est sale : " + monde.estSale(6, 6));
		
		System.out.println("=== On enlève le papier gras en position (5,5) ===");

		monde.prendPapierGras(5, 5);
		
		System.out.println(monde.toString());
		
		System.out.println("=== On essaye d'enlever un papier gras en position (6,6) : " + monde.prendPapierGras(6, 6) +  " ===");
		
		System.out.println("=== On essaye de placer un papier gras hors du monde : " + monde.metPapierGras(11, 11) + " ===");
		
		System.out.println("=== On essaye de regarde si une case est sale en dehors du monde : " + monde.estSale(11, 11) + " ===");
	
		System.out.println("\n=== TEST DES ROBOTS ===\n");
		
		
		System.out.println("=== Pollution par le Robot Pollueur Tout Droit sur toutes les colonnes ===\n");
		
		PollueurToutDroit pollueur1 = new PollueurToutDroit(0, 0, monde, 0);
		pollueur1.parcourir();
		
		pollueur1.setColDepart(2);
		pollueur1.parcourir();
		
		pollueur1.setColDepart(5);
		pollueur1.parcourir();
		
		pollueur1.setColDepart(9);
		pollueur1.parcourir();
		
		for (int i = 0; i != 10; i++) {
			pollueur1.setColDepart(i);
			pollueur1.parcourir();
		}
				
		System.out.println(monde.toString());
		
		System.out.println("=== Nettoyage par le Robot Nettoyeur ===\n");
		
		RobotNettoyeur nettoyeur1 = new RobotNettoyeur(0, 0, monde);
		nettoyeur1.parcourir();
		
		System.out.println(monde.toString());
		
		System.out.println("=== Pollution d'une colonne par le Robot Pollueur Tout Droit ===\n");
		
		pollueur1.setColDepart(5);
		pollueur1.parcourir();
		
		System.out.println(monde.toString());

		System.out.println("=== Nettoyage par le Robot Nettoyeur Distrait ===\n");

		for (int i = 0; i != 10; i++) {
			pollueur1.setColDepart(i);
			pollueur1.parcourir();
		}
		
		System.out.println(monde.toString());
		
		NettoyeurDistrait nettoyeur2 = new NettoyeurDistrait(0, 0, monde);
		nettoyeur2.parcourir();
		
		System.out.println(monde.toString());
		
		nettoyeur1.setCoordonnee(0, 0);
		nettoyeur1.parcourir();
		
		System.out.println("=== Pollution par le Robot Pollueur Sauteur avec un Deltax de 2 ===\n");

		PollueurSauteur pollueur2 = new PollueurSauteur(0, 0, monde, 2);
		pollueur2.parcourir();
		
		System.out.println(monde.toString());
		
	}
	
}
