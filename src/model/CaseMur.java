/**
 * 
 */
package model;

/**
 * @author kathryn
 *
 */
public class CaseMur extends CaseImplementee{
	
	/** CONSTRUCTEUR*/
	public CaseMur(int x, int y)
	{
		super(x,y); // appelle le constructeur de la classe m�re
		vasy=false;
		type='X';
	}

}
