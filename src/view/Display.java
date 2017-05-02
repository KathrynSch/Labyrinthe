/**
 * 
 */
package view;
import java.util.Scanner;
import model.*;
/**
 * @author kathr
 *
 */
public class Display {
	
	static Scanner userInput=new Scanner(System.in);
	
	public Display(){
		
	}
	
	/** Affiche le menu d'actions et retourne l'option selectionnée 
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
	}

}