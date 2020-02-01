import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercice_3 {
	
	public static void nbrMots(String nomFichier) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(nomFichier));
			
			String ligne;
			int nbrMots = 0;
			
			while ((ligne = br.readLine()) != null) {
				nbrMots += ligne.split(" ").length;
			}
			
			nbrMots--;
			
			br.close();
			
			System.out.println("Nombre de mots : " + nbrMots);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void nbrOccurenceMot(String nomFichier, String mot) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(nomFichier));
			
			String ligne;
			int nbrOccurence = 0;
			
			while ((ligne = br.readLine()) != null) {
				if (ligne.contains(mot))
					nbrOccurence++;		
			}
						
			br.close();
			
			System.out.println("Nombre d'occurence du mot : " + mot + " = " + nbrOccurence);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void suppressionEspaces(String nomFichier) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(nomFichier));
			
			int caractere;
			
			while ((caractere = br.read()) != -1) {
				if ((char)caractere != ' ' && (char)caractere != '\t' && (char)caractere != '\n' && (char)caractere != '\r') {
					System.out.write(caractere);
				}
			}
						
			br.close();
			
			System.out.print("\n");
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args) {
		
		if (args.length >= 1) {
			nbrMots(args[0]);
			suppressionEspaces(args[0]);
		} else {
			System.out.println("Veuillez rentrer un nom de fichier en premier argument !");
		}
		
		if (args.length == 2) {
			nbrOccurenceMot(args[0], args[1]);
		} else {
			System.out.println("Veuillez entrer un mot en second argument pour visualiser son nombre d'occurences.");
		}
		
	}
	
}
