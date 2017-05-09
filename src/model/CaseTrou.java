/**
 * Java Package MODEL
 * contient les classes relatives � la composition du jeu
 */
package model;

import java.awt.Image;

import javax.swing.ImageIcon;

/**Classe CaseTrou, h�rite de CaseImpl�ment�e
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
public class CaseTrou extends CaseImplementee{

	/**CONSTRUCTEUR
	 * @param x la position de la case
	 * @param y la position de la case
	 * appel constructeur de la classe m�re et envoie x, y
	 * attribut au bool vasy, true car case trou
	 * attribut au type _ car case trou
	 */
	public CaseTrou(int x, int y)
	{
		super(x,y); // appelle le constructeur de la classe m�re
		vasy=true;
		icon= new ImageIcon(new ImageIcon("trou.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		type="_";
	}
}
