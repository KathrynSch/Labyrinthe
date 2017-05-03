/**
 * Java Package MODEL
 * contient les classes relatives à la composition du jeu
 */
package model;

/**Classe CaseTrou, hérite de CaseImplémentée
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
public class CaseTrou extends CaseImplementee{

	/**CONSTRUCTEUR
	 * @param x la position de la case
	 * @param y la position de la case
	 * appel constructeur de la classe mère et envoie x, y
	 * attribut au bool vasy, true car case trou
	 * attribut au type _ car case trou
	 */
	public CaseTrou(int x, int y)
	{
		super(x,y); // appelle le constructeur de la classe mère
		vasy=true;
		type='_';
	}
}
