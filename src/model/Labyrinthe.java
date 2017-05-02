/**
 * 
 */
package model;

import model.Case;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
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
	 * d�clenche l'exception FileFormatException si le fichier ne peut etre lu ou si son format est incorrect
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
					}
					else if(c=='_'){
						nwCase=new CaseTrou(i,j);
					}
					else{
						//throw new FileFormatException();
					}
					cases[i][j]=nwCase;
				}	
			}
			cases[posY][posX].setType('o');
			input.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/** Tente de bouger le curseur dans la case (x,y) en param.
	 * Declenche l'exception ImpossibleMoveException si la case d�borde du labyrinthe ou si on ne peut pas aller dans la case
	 * @param x
	 * @param y
	 * @throws ImpossibleMoveException
	 */
	public boolean move (int x, int y) //throws ImpossibleMoveException
	{
		if(cases[y][x].canMoveToCase()) // si la case o� aller est un trou
		{
			cases[posY][posX].setType('_');
			posX=x;
			cases[y][x].setType('o');
			return true;
		}else{
			return false;
		}
	}
	
	/** Se d�place al�atoirement d'une seule case (direction en x, et y al�atoire) de la position courante (posX, posY)
	 * sauf si ce d�placment sort du labyrinthe ou va dans le mur
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
	
	
	public void setCurrentPosX(int x)
	{
		posX=x;
	}
	
	public void setCurrentPosY(int y)
	{
		posY=y;
	}
}
