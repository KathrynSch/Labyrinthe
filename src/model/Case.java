/**
 * 
 */
package model;

/**
 * @author kathryn
 *
 */
public interface Case {

	/** METHODES */
	
	/**
	 * @return la position en X de la case
	 */
	public int getPosX(); 
	
	/**
	 * @return la position en Y de la case
	 */
	public int getPosY();
	
	/**
	 * @return s'il est possible ou non d'aller dans la case
	 */
	public boolean canMoveToCase();
	
	public void setType(char t);
	public char getType();

	
}
