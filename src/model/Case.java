/**
 * Java Package MODEL
 * contient les classes relatives à la composition du jeu
 */
package model;

/** Interface de la classe CaseImplémentée
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
/**
 * @author kathr
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
	
	/**
	 * @return le char de la case à afficher en console
	 */
	public char getType();
	
	/**
	 * @param t le char correspondant au type de case
	 */
	public void setType(char t);
	

	
}
