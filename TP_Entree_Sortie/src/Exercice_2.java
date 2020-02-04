import java.io.*;

public class Exercice_2 {
	
	public static void Utilisation_Buffered_Reader(String fichier) {
		
		int compteur = 0;
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fichier));
			
			String ligne;
			
			while ((ligne = br.readLine()) != null) { //Tant qu'il y a des lignes à lire
				
				if (compteur % 2 == 0) { //Si la ligne est paire
					System.out.println(ligne); //Alors on l'affiche
				}
				
				compteur++;
				
			}
			
			br.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void Utilisation_LineNumberReader(String fichier) {
		
		try {
			
			LineNumberReader lnr = new LineNumberReader(new FileReader(fichier));
			
			String ligne;

			while ((ligne = lnr.readLine()) != null) { //Tant qu'il y a des lignes à lire
				
				if (lnr.getLineNumber() % 2 != 0) { //Si la ligne est paire
					System.out.println(ligne); //Alors on l'affiche
				}
				
			}
			
			lnr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static void main(String[] args) {	
		
		if (args.length == 1) {
			
			System.out.println("\n=== Affichage des lignes paires avec utilisation du Buffered Reader ===");
			Utilisation_Buffered_Reader(args[0]);
			System.out.println("\n=== Affichage des lignes paires avec utilisation du Line Number Reader ===");
			Utilisation_LineNumberReader(args[0]);
			
		} else { 
			System.out.println("Nombre d'arguments invalide !"); 
		}
		
	}
	
}
