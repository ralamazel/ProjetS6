package gestionfichier;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FichierCSV implements BaseDeDonnees{
	protected File path;
	
	
	
	public void Lecture(){
		Scanner sc;
		try {
			sc = new Scanner(path);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Fichier non trouvé");;
		}
		System.out.println("\n");
		
	}
}