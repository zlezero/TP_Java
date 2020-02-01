import java.io.*;
import java.awt.Point;

public class Exercice_4 {
	
	
	public static void sauvegarderPoint(Point point, String nomFichier) {
		
		try {
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomFichier));
			dos.writeInt(point.x);
			dos.writeInt(point.y);
			
			dos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Point lirePoint(String nomFichier) {
		
		try {
			
			DataInputStream dis = new DataInputStream(new FileInputStream(nomFichier));
			
			Point point = new Point(dis.readInt(), dis.readInt());
			
			dis.close();
			
			return point;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void sauvegarderPoint_2(Point point, String nomFichier) {
		
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier));
			oos.writeObject(point);
			oos.close();	

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Point lirePoint_2(String nomFichier) {
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier));		
			Point point = (Point) ois.readObject();
			ois.close();
			
			return point;
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		if (args.length == 3) {
			
			System.out.println("\n=== Utilisation DataOutputStream / DataInputStream ===");
			
			System.out.println("Sauvegarde du point : (" + args[0] + ";" + args[1] + ") dans le fichier : " + args[2]);
			sauvegarderPoint(new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1])), args[2]);
			Point pointLu = lirePoint(args[2]);
			System.out.println("Point lu dans le fichier " + args[2] + " : (" + pointLu.x + ";" + pointLu.y + ")");
			
			System.out.println("\n=== Utilisation ObjectOutputStream / ObjectInputStream ===");
			
			System.out.println("Sauvegarde du point : (" + args[0] + ";" + args[1] + ") dans le fichier : " + args[2]);
			sauvegarderPoint_2(new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1])), args[2]);
			pointLu = lirePoint_2(args[2]);
			System.out.println("Point lu dans le fichier " + args[2] + " : (" + pointLu.x + ";" + pointLu.y + ")");
			
			
		}
		
	}
	
}
