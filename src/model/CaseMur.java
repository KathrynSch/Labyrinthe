/**
 * Java Package MODEL
 * contient les classes relatives à la composition du jeu
 */
package model;

import java.awt.Image;

import javax.swing.ImageIcon;

/**Classe CaseMur, hérite de CaseImplémentée
 * @author kathryn
 * @author pauline
 * @version 1.0
 */
public class CaseMur extends CaseImplementee{
	
	/**CONSTRUCTEUR
	 * @param x la position de la case
	 * @param y la position de la case
	 * appel constructeur de la classe mère et envoie x, y
	 * attribut au bool vasy, false car case mur
	 * attribut au type X car case mur
	 */
	public CaseMur(int x, int y)
	{
		super(x,y); // appelle le constructeur de la classe mère
		vasy=false;
		icon= new ImageIcon(new ImageIcon("coral.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));;
		type="X";
	}

}
