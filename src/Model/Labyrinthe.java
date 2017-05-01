/**
 * 
 */
package Model;

/**
 * @author kathr
 *
 */
public class Labyrinthe {
	
	/** ATTRIBUTS */
	private int tailleX;
	private int tailleY;
	private int departX;
	private int departY;
	private int posX;
	private int posY;
	private Case[][] cases;
	
	public Labyrinthe(int tx, int ty, int dx, int dy, int px, int py)
	{
		tailleX=tx;
		tailleY=ty;
		departX=dx;
		departY=dy;
		posX=px;
		posY=py;
	}
	/** Lit un labyrinthe avec un fichier en param
	 * Initialise tous les attributs avec les valeurs lues dans le fichier 
	 * puis instancie la collection de cases et chaque case
	 * déclenche l'exception FileFormatException si le fichier ne peut etre lu ou si son format est incorrect
	 * @param lab
	 * @throws FileFormatException
	 */
	public void initFromFile(File lab) throws FileFormatException
	{
		
	}
	
	/** Tente de bouger le curseur dans la case (x,y) en param.
	 * Declenche l'exception ImpossibleMoveException si la case déborde du labyrinthe ou si on ne peut pas aller dans la case
	 * @param x
	 * @param y
	 * @throws ImpossibleMoveException
	 */
	public void move (int x, int y) throws ImpossibleMoveException
	{
		
	}
	
	/** Se déplace aléatoirement d'une seule case (direction en x, et y aléatoire) de la position courante (posX, posY)
	 * sauf si ce déplacment sort du labyrinthe ou va dans le mur
	 */
	public void autoMove()
	{
		
	}
	
	/**
	 * @return current position X posX
	 */
	public int getCurrentPositionX()
	{
		return posX;
	}
	
	/**
	 * @return current position Y posY
	 */
	public int getCurrentPositionY()
	{
		return posY;
	}
	
}
