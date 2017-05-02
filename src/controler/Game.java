/**
 * 
 */
package controler;

import model.Labyrinthe;
import view.Display;
import model.Case;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Robot;


/**
 * @author kathr
 *
 */

public class Game{
	
	static Scanner userInput =new Scanner(System.in);
	static Display display= new Display();
	static Robot r;
	
	public static void main(String[] args)
	{		
		System.out.println("Choisissez un niveau:");
		System.out.println("1: niveau 1");
		System.out.println("2: niveau 2");
		System.out.println("3: niveau 3");
		if(userInput.hasNextInt())
		{
			int niveau=userInput.nextInt();
			switch(niveau){
				case 1: //open file niveau1.txt
						File file= new File("niveau1.txt");
						Labyrinthe laby= new Labyrinthe();
						laby.initFromFile(file);
						play(laby);
					break;
				case 2: // open file niveau2.txt
					break;
				case 3: //open file niveau3.txt
					break;
			}
	
			
		}
		
	}
	
	public static void play(Labyrinthe laby)
	{
		//position départ joueur
		//r.mouseMove(0,0);

		display.dispLab(laby);
		int choix=display.menu();
		switch (choix)
		{
			case 1: //deplacement manuel
					deplacer(laby);
				break;
			case 2: //deplacement automatique intelligent
				break;
			case 3: //deplacment automatique aléatoire et sortie de jeu
				break;
			default: System.out.println("Invalid option");
				break;
		}
		
	}
	
	public static void deplacer(Labyrinthe laby)
	{
		System.out.println("deplacer");
		do{
			display.dispLab(laby);
			boolean moved=false;
			//r.mouseMove(100, 100);
			while(!moved){
				String dir = userInput.nextLine();
				
				if("q".equals(dir)){
					//fleche gauche
					moved=laby.move(laby.getCurrentPosY()-1, laby.getCurrentPosX());
				}
				if("d".equals(dir)){
					//fleche droite
					moved=laby.move(laby.getCurrentPosY()+1, laby.getCurrentPosX());
				}
				if("z".equals(dir)){
					//fleche haut
					moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()-1);
				}
				if("s".equals(dir)){
					//fleche bas
					moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()+1);
				}
			}			
		}while(!laby.isWin());
		
		
		
	}

}
