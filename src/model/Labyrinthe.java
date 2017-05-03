/**
 * 
 */
package model;

import model.Case;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @author kathr
 *
 */
public class Labyrinthe {
	
	/** ATTRIBUTS */
	private int tailleX;
	private int tailleY;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int posX;
	private int posY;
	private Case[][] cases;
	
	public Labyrinthe() //constructeur
	{
		tailleX=0;
		tailleY=0;
		startX=0;
		startY=0;
		endX=0;
		endY=0;
		posX=0;
		posY=0;
	}
	/** Lit un labyrinthe avec un fichier en param
	 * Initialise tous les attributs avec les valeurs lues dans le fichier 
	 * puis instancie la collection de cases et chaque case
	 * déclenche l'exception FileFormatException si le fichier ne peut etre lu ou si son format est incorrect
	 * @param lab
	 * @throws FileFormatException
	 */
	public void initFromFile(File file) //throws FileFormatException(lab)
	{
		try{
			Scanner input = new Scanner(file);
			// initialise attributs
			tailleX=input.nextInt();
			tailleY=input.nextInt();
			startX=posX=input.nextInt();
			startY=posY=input.nextInt();
			endX=input.nextInt();
			endY=input.nextInt();
			
			cases=new Case[tailleX][tailleY];
			Case nwCase=null;
			for(int i=0; i<tailleY; i++)
			{
				input.nextLine();
				String line=input.next();
				int ch=0;
				for(int j=0; j<tailleX;j++)
				{	
					char c=line.charAt(ch++);
					if(c=='X'){
						nwCase=new CaseMur(i,j);
						//System.out.println("New mur");
					}
					else if(c=='_'){
						nwCase=new CaseTrou(i,j);
						//System.out.println("New trou");
					}
					cases[i][j]=nwCase;
				}	
			}
			cases[startY][startX].setType('*');
			cases[endY][endX].setType('O');
			input.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/** Tente de bouger le curseur dans la case (x,y) en param.
	 * Declenche l'exception ImpossibleMoveException si la case déborde du labyrinthe ou si on ne peut pas aller dans la case
	 * @param x
	 * @param y
	 * @throws ImpossibleMoveException
	 */
	public boolean move (int y, int x) 
	{
		try{
			if(cases[y][x].canMoveToCase()) // si la case où aller est un trou
			{
				//System.out.println("canMove");
				cases[posY][posX].setType('_');
				//System.out.println("Case A:: posY: "+posY+", posX: "+posX);
				posX=x;
				posY=y;
				//System.out.println("Vers Case B:: posY: "+posY+", posX: "+posX);
				cases[y][x].setType('*');
				return true;
			}else{
				//System.out.println("canNotMove vers y="+y+" x="+x);
				return false;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("out of matrix");
			return false;
			
		}
	}
	
	/** Se déplace aléatoirement d'une seule case (direction en x, et y aléatoire) de la position courante (posX, posY)
	 * sauf si ce déplacment sort du labyrinthe ou va dans le mur
	 */
	public void autoMove()
	{
		//
	}
	
	public boolean isWin()
	{
		if((posX==endX)&&(posY==endY))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * @return current position X posX
	 */
	public int getCurrentPosX()
	{
		return posX;
	}
	
	/**
	 * @return current position Y posY
	 */
	public int getCurrentPosY()
	{
		return posY;
	}
	
	public int getTailleX()
	{
		return tailleX;
	}
	public int getTailleY()
	{
		return tailleY;
	}
	public Case[][] getCases()
	{
		return cases;
	}
	
}
