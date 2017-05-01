/**
 * 
 */
package Model;

/**
 * @author kathryn
 *
 */
public interface Case {

	/** METHODES */
	
	/**
	 * @return la position en X de la case
	 */
	public int getPositionX(); 
	
	/**
	 * @return la position en Y de la case
	 */
	public int getPositionY();
	
	/**
	 * @return s'il est possible ou non d'aller dans la case
	 */
	public boolean canMoveToCase();
	
}
