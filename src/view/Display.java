/**
 * Java Package View
 * contient les classes relatives à l'affichage
 */
package view;
import java.util.Scanner;
import model.*;
/**
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
public class Display {
	
	static Scanner userInput=new Scanner(System.in);
	
	public Display(){
		
	}
	

	/** Affiche le menu d'actions
	 * @return l'option sélectionnée
	 */
	public int menu()
	{
		int choice=0;
		System.out.println("Menu");
		System.out.println("1: Déplacement manuel");
		System.out.println("2: Deplacement automatique intelligent");
		System.out.println("3: Deplacement automatique aleatoire et sortie du jeu");
		System.out.println("Choisissez une action:");
		if(userInput.hasNextInt())
		{
			choice=userInput.nextInt();
		}
		return choice;
	}
	
	/** affiche welcome menu
	 * @return option de niveau sélectionné
	 */
	public int welcome()
	{
		System.out.println("Choisissez un niveau:");
		System.out.println("1: niveau 1");
		System.out.println("2: niveau 2");
		System.out.println("3: niveau 3");
		if(userInput.hasNextInt())
		{
			int niveau=userInput.nextInt();
			return niveau;
		}
		return 0;
	}
	
	/**Affiche labyrinthe
	 * @param laby
	 */
	public void dispLab(Labyrinthe laby)
	{
		Case[][] cases=laby.getCases();
		for(int i=0;i<laby.getTailleY();i++)
		{
			for(int j=0;j<laby.getTailleX();j++)
			{
				
					System.out.print(cases[i][j].getType());
				
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}

}