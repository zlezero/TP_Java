
public class Monde {
	
	private int nbL;
	private int nbC;
	private boolean[][] mat;
	
	public Monde() {
		mat = new boolean[10][10];
		nbL = 9;
		nbC = 9;
	}
	
	public Monde(int nbrLignes, int nbrColonnes) {
		mat = new boolean[nbrColonnes][nbrLignes];
		nbL = nbrLignes;
		nbC = nbrColonnes;
	}
	
	public String toString() {
		
		String monde = "";
		
		for (int i = 0; i < nbC; i++) {
			
			for (int j = 0; j < nbL; j++) {
				
				if (mat[i][j] == true)
					monde += "o";
				else
					monde += ".";
				
			}
			
			monde += "\n";
			
		}
			
		return monde;
		
	}
	
	public boolean metPapierGras(int i, int j) {
		if (i <= nbL && j <= nbC) {
			mat[i][j] = true;
			return true;
		}
		else
			return false;
	}
	
	public boolean prendPapierGras(int i, int j) {
		if (i <= nbL && j <= nbC) {
			
			if (mat[i][j]) {
				mat[i][j] = false;
				return true;
			} 
			else 
				return false;
			
		}
		else
			return false;
	}
	
	public boolean estSale(int i, int j) {
		if (i <= nbL && j <= nbC)
			return mat[i][j] == true;
		else
			return false;
	}
	
	public int nbPapiersGras() {
		
		int nbrPapiersGras = 0;
		
		for (int i = 0; i < nbL; i++) {
			
			for (int j = 0; j < nbC; i++) {
				if (mat[i][j] == true)
					nbrPapiersGras += 1;
			}
						
		}
		
		return nbrPapiersGras;
		
	}

	public int getNbL() {
		return nbL;
	}

	public int getNbC() {
		return nbC;
	}
	
	
}
