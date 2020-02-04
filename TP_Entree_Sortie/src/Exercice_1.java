import java.io.*;

public class Exercice_1 {
	
	public static void Exercice_1_1() {
		
		int data = 0;
		
		try {
			
			while ((data = System.in.read()) != -1) {
				System.out.write(data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void copieFichiers(InputStream inputStream, OutputStream outputStream) {
		
		try {
			
			int data = 0;
			
			BufferedInputStream bis = new BufferedInputStream(inputStream, 8000);
			BufferedOutputStream bos = new BufferedOutputStream(outputStream, 8000);
			
			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			
			bis.close();
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		System.out.println("=== Copie des fichiers === ");
		try {
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			
			if (args.length == 2) {
				
				System.out.println("Copie de " + args[0] + " vers " + args[1]);
				inputStream = new FileInputStream(args[0]);
				outputStream = new FileOutputStream(args[1]);
				
			} else {
				inputStream = System.in;
				outputStream = System.out;
			}
				
			copieFichiers(inputStream, outputStream);
			
			inputStream.close();
			outputStream.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=== Lecture de l'entrée standard et recopie dans la sortie standard === ");
		Exercice_1_1();
		
	}

}
