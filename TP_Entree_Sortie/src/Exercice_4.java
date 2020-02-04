import java.io.*;
import java.util.ArrayList;
import java.awt.Point;

public class Exercice_4 {
	
	
	public static void sauvegarderPoint(Point[] point, String nomFichier) {
		
		try {
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomFichier));
			
			for (int i = 0; i < point.length; i++) {
				dos.writeInt(point[i].x);
				dos.writeInt(point[i].y);
			}
			
			dos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Point[] lirePoint(String nomFichier) {
		
		try {
			
			DataInputStream dis = new DataInputStream(new FileInputStream(nomFichier));
			
			ArrayList<Point> point = new ArrayList<Point>();
			
			while (dis.available() > 0) {
				point.add(new Point(dis.readInt(), dis.readInt()));	
			}
			
			dis.close();
			
			return (Point[]) point.toArray(new Point[0]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void sauvegarderPoint_2(Point[] point, String nomFichier) {
		
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier));
			oos.writeObject(point);
			oos.close();	

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Point[] lirePoint_2(String nomFichier) {
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier));		
			Point[] point = (Point[]) ois.readObject();			
			ois.close();
			
			return point;
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		Point point[] = {new Point(2, 4), new Point(5, 8), new Point(9, 7), new Point(10, 56), new Point()};
		
		if (args.length == 3) {
			
			System.out.println("\n=== Utilisation DataOutputStream / DataInputStream ===");
			
			point[point.length - 1] = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			
			System.out.println("Sauvegarde du point : (" + args[0] + ";" + args[1] + ") dans le fichier : " + args[2]);
			sauvegarderPoint(point, args[2]);
			Point[] pointLu = lirePoint(args[2]);
			System.out.println("Point lu dans le fichier " + args[2] + " : ");
			
			System.out.print("[");
			
			for (int i = 0 ; i < pointLu.length; i++) {
				System.out.print("(" + pointLu[i].x + ";" + pointLu[i].y + "),");
			}
			
			System.out.print("]");
			
			System.out.println("\n=== Utilisation ObjectOutputStream / ObjectInputStream ===");
			
			System.out.println("Sauvegarde du point : (" + args[0] + ";" + args[1] + ") dans le fichier : " + args[2]);
			sauvegarderPoint_2(point, args[2]);
			pointLu = lirePoint_2(args[2]);
			System.out.println("Point lu dans le fichier " + args[2] + " : ");
			
			System.out.print("[");
			
			for (int i = 0 ; i < pointLu.length; i++) {
				System.out.print("(" + pointLu[i].x + ";" + pointLu[i].y + "),");
			}
			
			System.out.println("]");
			
			
		} else { System.out.println("Nombre d'arguments invalide ! Utilisation java Exercice4 <X> <Y> <FichierDeSauvegarde>"); }
		
	}
	
}
