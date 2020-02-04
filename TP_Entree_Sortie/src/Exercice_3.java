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
			
			while ((ligne = br.readLine()) != null) { //Tant qu'il y a des lignes à lire
				nbrMots += ligne.split(" ").length; //On regarde le nombre d'espaces pour savoir le nombre de mots sur une ligne
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
			
			while ((ligne = br.readLine()) != null) { //Tant qu'il y a des lignes à lire
				if (ligne.contains(mot)) //Si une ligne contient le mot que l'on recherche
					nbrOccurence++;		//Alors on augmente le nombre d'occurences trouvées
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
			
			while ((caractere = br.read()) != -1) { //Tant qu'il y a des caractères à lire
				if ((char)caractere != ' ' && (char)caractere != '\t' && (char)caractere != '\n' && (char)caractere != '\r') { //Si il ne s'agit pas d'un espace, d'une tabulation ou d'un saut de ligne
					System.out.write(caractere); //Alors on écrit le caractère
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
