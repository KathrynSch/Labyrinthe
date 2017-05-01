/**
 * 
 */
package View;
import java.util.Scanner;

/**
 * @author kathr
 *
 */
public class Display {
	
	static Scanner userInput=new Scanner(System.in);
	
	/** Affiche le menu d'actions et retourne l'option selectionnée 
	 */
	public void menu()
	{
		
		System.out.println("Menu");
		System.out.println("1: Déplacement manuel");
		System.out.println("2: Deplacement automatique intelligent");
		System.out.println("3: Deplacement automatique aleatoire et sortie du jeu");
		System.out.println("Choisissez une action:");
		if(userInput.hasNextInt())
		{
			int choice=userInput.nextInt();
			switch (choice)
			{
				case 1: //
					break;
				case 2: //
					break;
				case 3: //
					break;
				default: System.out.println("Invalid option");
					break;
			}
			
		}
	}
	public void dispLab()
	{
		
	}

}