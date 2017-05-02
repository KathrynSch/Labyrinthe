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
import java.lang.Runtime;


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
		boolean endGame=false;
		while(!endGame)
		{
			System.out.println("Choisissez un niveau:");
			System.out.println("1: niveau 1");
			System.out.println("2: niveau 2");
			System.out.println("3: niveau 3");
			File file=null;
			if(userInput.hasNextInt())
			{
				int niveau=userInput.nextInt();
				switch(niveau){
					case 1: file= new File("niveau1.txt");
						break;
					case 2: file= new File("niveau2.txt");
						break;
					case 3: file= new File("niveau3.txt");
						break;
				}
				Labyrinthe laby= new Labyrinthe();
				laby.initFromFile(file);
				play(laby);
				endGame=endGame();
				file=null;
				laby=null;
			}
		}
		
	}
	
	public static void play(Labyrinthe laby)
	{
		/**try{
			Runtime.getRuntime().exec("clear");
		}catch(IOException e){
			e.printStackTrace();
		}*/
		//position d�part joueur
		//r.mouseMove(0,0);

		display.dispLab(laby);
		int choix=display.menu();
		switch (choix)
		{
			case 1: //deplacement manuel
					deplacer(laby);
				break;
			case 2: //deplacement automatique intelligent
					intelligent(laby);
				break;
			case 3: //deplacment automatique al�atoire et sortie de jeu
				break;
			default: System.out.println("Invalid option");
				break;
		}
		
	}
	
	
	public static void deplacer(Labyrinthe laby)
	{
		System.out.println("Appuyez sur: z, s, d, ou f");
		while(!laby.isWin()){
			display.dispLab(laby);
			boolean moved=false;
			//r.mouseMove(100, 100);
			while(!moved){
				String dir = userInput.nextLine();
				
				if("q".equals(dir)){
					//fleche gauche
					moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()-1);
				}
				if("d".equals(dir)){
					//fleche droite
					moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()+1);
				}
				if("z".equals(dir)){
					//fleche haut
					moved=laby.move(laby.getCurrentPosY()-1, laby.getCurrentPosX());
				}
				if("s".equals(dir)){
					//fleche bas
					moved=laby.move(laby.getCurrentPosY()+1, laby.getCurrentPosX());
				}
			}			
		}
		if(laby.isWin()){
			System.out.println("gagne !!");
		}
	}
	
	public static void intelligent(Labyrinthe laby)
	{	int Max=4;
		int Min=1;
		while(!laby.isWin()){
			display.dispLab(laby);
			boolean moved=false;
			while(!moved){
				//String dir = userInput.nextLine();
				int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));
				
				if(nombreAleatoire==1){
					//fleche gauche
					moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()-1);
				}
				if(nombreAleatoire==2){
					//fleche droite
					moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()+1);
				}
				if(nombreAleatoire==3){
					//fleche haut
					moved=laby.move(laby.getCurrentPosY()-1, laby.getCurrentPosX());
				}
				if(nombreAleatoire==4){
					//fleche bas
					moved=laby.move(laby.getCurrentPosY()+1, laby.getCurrentPosX());
				}
			}			
		}
		if(laby.isWin()){
			System.out.println("gagne !!");
		}
	}
	
	
	public static boolean endGame()
	{
		System.out.println("REJOUER ?");
		System.out.println("1: OUI   2: NON");
		int choix=userInput.nextInt();
		switch(choix){
			case '1': return false;
			case '2': return true;
			default: return true;
		}
	}
}
