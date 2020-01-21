
public class Carre_Magique {
	
	private int matrice[][];
	
	public Carre_Magique(int tailleCarre) throws NonImpaireException {
		
		if (tailleCarre % 2 == 0) {
			throw new NonImpaireException("La taille doît être impaire");
		}
		
		matrice = new int[tailleCarre][tailleCarre];
		
	}
	
	public void calculer() {
				
		int posY = (matrice.length / 2) - 1;
		int posX = matrice.length / 2;
		
		matrice[posY][posX] = 1;
		
		for (int i = 2; i < (matrice.length * matrice.length) + 1; i++) {		
				
			posX++;
			posY--;
				
			if (inMat(posX, posY) && matrice[posY][posX] == 0) { //On met en haut à gauche
				matrice[posY][posX] = i;
			}
			else if (inMat(posX, posY) && matrice[posY][posX] != 0) { //Si la case en haut à gauche est pleine
					
				posX--;
				posY--;
				
				if (inMat(posX, posY)) { //Si la nouvelle position est dans la matrice
					matrice[posY][posX] = i;			
				}
				
			}
			
			if (!inMat(posX, posY) && inMat(posX, matrice.length - 1) && matrice[matrice.length - 1][posX] == 0) { 	
				matrice[matrice.length - 1][posX] = i;
				posY = matrice.length - 1;
			}
			else if (!inMat(posX, posY) && inMat(posY, 0) && matrice[posY][0] == 0) {
				matrice[posY][0] = i;
				posX = 0;
			}
			else if (!inMat(posX, posY)) {
				
				posX--;
				posY = matrice.length - 1;
				
				while (matrice[posY][posX] != 0) {
					posY--;
				}
				
				matrice[posY][posX] = i;
				
			}

		}
		
	}
	
	public void calculerAvecException() {
		
		int posY = (matrice.length / 2) - 1;
		int posX = matrice.length / 2;
		int compteur = 2;
		
		matrice[posY][posX] = 1;
		
		while (!estResolu()) {
			
			try {
				
				matrice[posY][posX] = compteur;
				compteur++;
				
				posX++;
				posY--;
				
				if (matrice[posY][posX] != 0) {
					throw new CasePleineException("");
				}
							
			} 
			catch (ArrayIndexOutOfBoundsException e) {
				
				if (estColonneValide(posX)) {
					posY = matrice.length - 1;
				} else {
					
					if (posX < 0) {
						posX = matrice.length -1;
					} else {
						posX = 0;
					}
				}
				
			} 
			catch (CasePleineException e) {
				posX--;
				posY--;
				
			}
								
		}
				
	}
	
	private boolean estColonneValide(int posX) {
		return posX >= 0 && posX < matrice.length;
	}
	
	private boolean estResolu() {
		
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				if (matrice[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
		
	private boolean inMat(int posX, int posY) {
		return posX >= 0 && posY >= 0 && posX < matrice.length && posY < matrice.length;
	}
	
	
	public String toString() {
		
		String stringMatrice = new String();
		
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				if (matrice[i][j] < 10) {
					stringMatrice += "[" + matrice[i][j] + " ]";
				} else {
					stringMatrice += "[" + matrice[i][j] + "]";
				}
			}
			stringMatrice += "\n";
		}
		
		return stringMatrice;
		
	}

	public static void main(String[] args) {
		
		
		try {
			
			Carre_Magique carreMagique = new Carre_Magique(5);
			
			System.out.println("=== Carré magique avant ===\n");
			System.out.println(carreMagique);
			carreMagique.calculer();
			System.out.println("=== Carré magique après ===\n");
			System.out.println(carreMagique);
			
			Carre_Magique carreMagique2 = new Carre_Magique(5);
			//System.out.println("=== Carré magique après 2 ===\n");
			//carreMagique2.calculerAvecException();
			//System.out.println(carreMagique2);

			
		} catch (NonImpaireException e) {
			System.out.println("La taille du carré magique doit être impaire !");
		}
		
	}

}
