/**
 * Java Package Controler
 * contient les classes relatives au tournement du jeu
 */
package controler;

import model.Labyrinthe;
import view.Display;
import java.util.Scanner;
import java.io.File;
import java.awt.Robot;


/** Classe Game contient methodes relatives au fonctionnement du jeu
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
public class Game{
	
	static Scanner userInput =new Scanner(System.in);
	static Display display= new Display();
	static Robot r;
	
	/**Main lance le jeu et appelle les fonctions nécessaires au déroulement
	 * @param args
	 */
	public static void main(String[] args)
	{	
		boolean endGame=false;
		while(!endGame)
		{
			File file=null;
			int niveau = display.welcome();
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
	
	/** function play affiche partie et envoie vers mode de jeu choisi
	 * @param laby
	 */
	public static void play(Labyrinthe laby)
	{
		display.dispLab(laby);
		int choix=display.menu();
		switch (choix)
		{
			case 1: //deplacement manuel
					manuel(laby);
				break;
			case 2: //deplacement automatique intelligent
					
				break;
			case 3: //deplacment automatique aleatoire et sortie de jeu
					robot(laby);
				break;
			default: System.out.println("Invalid option");
				break;
		}
	}
	
	
	/** lance jeu en mode manuel
	 * @param laby
	 */
	public static void manuel(Labyrinthe laby)
	{
		int compteur=0;
		System.out.println("Appuyez sur: z, s, d, ou f");
		while(!laby.isWin()){
			display.dispLab(laby);
			boolean moved=false;
			//r.mouseMove(100, 100);
			while(!moved){
				String dir = userInput.nextLine();
				moved=deplacer(laby, dir);
				if(moved){compteur++;}
			}			
		}
		if(laby.isWin()){
			display.dispLab(laby);
			System.out.println("gagne !!");
			System.out.println("Nombre de coups: "+compteur);
		}
	}
	
	/** permet de déplacer le user vers la direction envoyée
	 * @param laby
	 * @param dir vers la case où se déplacer
	 * @return true if moved case, false otherwise
	 */
	public static boolean deplacer(Labyrinthe laby, String dir)
	{
		if("q".equals(dir)){
			//fleche gauche
			return laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()-1);
		}
		if("d".equals(dir)){
			//fleche droite
			return laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()+1);
		}
		if("z".equals(dir)){
			//fleche haut
			return laby.move(laby.getCurrentPosY()-1, laby.getCurrentPosX());
		}
		if("s".equals(dir)){
			//fleche bas
			return laby.move(laby.getCurrentPosY()+1, laby.getCurrentPosX());
		}
		else{
			return false;
		}
	}
	
	/** lance jeu en aléatoire totale
	 * @param laby
	 */
	public static void robot(Labyrinthe laby)
	{	
		int compteur=0;
		int Max=3, Min=0;
		String[] dir={"q","d","s","z"};
		while(!laby.isWin()){
			display.dispLab(laby);
			boolean moved=false;
			while(!moved){
				int rdm = Min + (int)(Math.random() * ((Max - Min) + 1));
				moved=deplacer(laby, dir[rdm]);
				if(moved){compteur++;}
			}			
		}
		if(laby.isWin()){
			display.dispLab(laby);
			System.out.println("gagne !!");
			System.out.println("Nombre de coups: "+compteur);
		}
	}
	
	/**
	 * @return true if user wants to quit, false otherwise
	 */
	public static boolean endGame()
	{
		System.out.println("REJOUER ?");
		System.out.println("1: OUI   2: NON");
		int choix=userInput.nextInt();
		switch(choix){
			case 1: 
				return false;
			case 2: return true;
			default: return true;
		}
	}
}
