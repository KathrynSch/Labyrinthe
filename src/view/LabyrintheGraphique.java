/**
 * 
 */
package view;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import model.Labyrinthe;

/**
 * @author kathr
 *
 */
public class LabyrintheGraphique extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Labyrinthe laby;
	JPanel panelLaby= new JPanel();
	JPanel panelAction= new JPanel();
	JPanel panelMain= new JPanel();
	static BorderLayout border=new BorderLayout();

	// contient grille labyrinthe, boutons dir, boutons robot et smart
	static JButton upButton= new JButton("UP");
	static JButton downButton= new JButton("DOWN");
	static JButton leftButton= new JButton("LEFT");
	static JButton rightButton= new JButton("RIGHT");
	static JButton robotButton= new JButton("ROBOT");
	static JButton smartButton= new JButton("SMART");
	static JButton[][] matrice=null;
	
	
	
	
	public LabyrintheGraphique(Labyrinthe lab)
	{
		
		super();
		panelMain.add(panelLaby);
		panelMain.add(panelAction);

		
		laby=lab;
		GridLayout grid= new GridLayout(laby.getTailleY()+3, laby.getTailleX());
		panelLaby.setLayout(grid);
		//creation matrice
		matrice=new JButton[laby.getTailleY()][laby.getTailleX()];
		for(int i=0; i<laby.getTailleY();i++){
			for(int j=0; j<laby.getTailleX();j++){
				matrice[i][j]=new JButton(laby.getCases()[i][j].getType());
				panelLaby.add(matrice[i][j]);
			}
		}
		
		//creation autres boutons
		panelAction.setLayout(border);
		panelAction.add(upButton, border.NORTH);
		panelAction.add(downButton,border.CENTER);
		panelAction.add(leftButton,border.WEST);
		panelAction.add(rightButton,border.EAST);
		panelAction.add(robotButton,border.SOUTH);
		panelAction.add(smartButton,border.SOUTH);
		upButton.addActionListener(this);
		downButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		robotButton.addActionListener(this);
		smartButton.addActionListener(this);
		
		build();
	}
	
	private void build()
	{
		setTitle("Labyrinthe");//titre de la fenetre
		setSize(600,600);//dimensions de la fenetre
		setLocationRelativeTo(null);//positionnement au centre de l'�cran
		setResizable(true);// pas de redimensionnement possible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fenetre se ferme par appuye sur croix
		setContentPane(panelLaby);
		setContentPane(panelAction);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int x=laby.getCurrentPosX();
		int y=laby.getCurrentPosY();
		boolean moved=false;
		Object source= e.getSource();
		if(source == upButton)
		{
			System.out.println("up !");
			moved=laby.move(laby.getCurrentPosY()-1, laby.getCurrentPosX());
			if(moved){
				matrice[y][x].setText("_");
				matrice[y-1][x].setText("*");
			}
		}
		else if(source == downButton)
		{
			System.out.println("down !");
			moved=laby.move(laby.getCurrentPosY()+1, laby.getCurrentPosX());
			if(moved){
				matrice[y][x].setText("_");
				matrice[y+1][x].setText("*");
			}
				
		}
		else if(source == rightButton)
		{
			System.out.println("right !");
			moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()+1);
			if(moved){
				matrice[y][x].setText("_");
				matrice[y][x+1].setText("*");
			}
		}
		else if(source == leftButton)
		{
			System.out.println("left !");
			moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()-1);
			if(moved){
				matrice[y][x].setText("_");
				matrice[y][x-1].setText("*");
			}
		}
		else if(source == robotButton)
		{
			System.out.println("robot !");
		}
		else if(source == smartButton)
		{
			System.out.println("smart !");
		}
			
	}

}
