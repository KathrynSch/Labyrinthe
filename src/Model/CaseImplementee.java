/**
 * 
 */
package Model;

/**
 * @author kathryn
 *
 */
public class CaseImplementee implements Case{
	
	/** ATTRIBUTS 
	 * position en X et en Y de la case
	 * bool vasy indique si il est possible ou non d'aller dans la case
	 */
	protected int posX;
	protected int posY;
	protected boolean vasy;
	
	/** CONSTRUCTEUR*/
	public CaseImplementee(int x, int y)
	{
		posX=x;
		posY=y;
		System.out.println("Creation d'une case à la position "+ x+";"+y);
	}
	/** METHODES*/
	/**
	 * @return la position en X de la case
	 */
	public int getPositionX()
	{
		return posX;
	}
	/**
	 * @return la position en Y de la case
	 */
	public int getPositionY()
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

}
