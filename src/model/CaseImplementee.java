/**
 * Java Package MODEL
 * contient les classes relatives à la composition du jeu
 */
package model;

/** Classe CaseImplémentée mère de CaseMur et CaseTrou
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
public class CaseImplementee implements Case{
	
	/** ATTRIBUTS 
	 * position en X et en Y de la case
	 * bool vasy indique si il est possible ou non d'aller dans la case
	 * char type qui correspond au caractère à afficher en console
	 */
	protected int posX;
	protected int posY;
	protected boolean vasy;
	protected char type;
	
	/** CONSTRUCTEUR
	 * @param x donne la position de la case
	 * @param y donne la position de la case
	 */
	public CaseImplementee(int x, int y)
	{
		posX=x;
		posY=y;
	}
	/** METHODES*/
	/**
	 * @return la position en X de la case
	 */
	public int getPosX()
	{
		return posX;
	}
	/**
	 * @return la position en Y de la case
	 */
	public int getPosY()
	{
		return posY;
	}
	/**
	 * @return s'il est possible ou non d'aller dans la case
	 */
	public boolean canMoveToCase() // get vasy
	{
		if(vasy)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void setType(char t)
	{
		type=t;
	}

	public char getType()
	{
		return type;
	}

}
