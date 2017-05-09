/**
 * Java Package View
 * contient les classes relatives � l'affichage
 */
package view;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Font;
import model.Labyrinthe;
import java.awt.event.ActionListener;


/**
 * @author kathryn
 * @author pauline
 * @version 2.0
 */
public class LabyrintheGraphique extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	static Labyrinthe laby;
	// Panels
	static JPanel panelLaby= new JPanel();
	static JPanel panelAction= new JPanel();
	static JPanel panelMain= new JPanel(); //container

	// grille labyrinthe, boutons dir, boutons robot et smart
	static JButton upButton= new JButton("UP");
	static JButton downButton= new JButton("DOWN");
	static JButton leftButton= new JButton("LEFT");
	static JButton rightButton= new JButton("RIGHT");
	static JButton robotButton= new JButton("ROBOT");
	static JButton smartButton= new JButton("SMART");
	static JButton[][] matrice=null;
	
	//Text
	static JLabel title= new JLabel();
	static JLabel comments= new JLabel();
	
	//game components
	static int compteur=0;
	static ImageIcon fish=new ImageIcon(new ImageIcon("fish.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	static ImageIcon or=new ImageIcon(new ImageIcon("or.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	
	/**Constructeur de la fenetre graphique
	 * initialise la fenetre graphique avec le composants n�cessaires
	 * @param lab labyrinthe envoy� par le main
	 */
	public LabyrintheGraphique(Labyrinthe lab)
	{
		
		super();
		//panel Main
		BoxLayout box=new BoxLayout(panelMain,BoxLayout.Y_AXIS);
		panelMain.setLayout(box);
		
		//add elements to main
		panelMain.add(title);
		panelMain.add(panelLaby);
		panelMain.add(panelAction);
		panelMain.add(comments);
		
		//set laby
		laby=lab;
		
		//labels
		title.setText("Labyrinthe niveau "+laby.getNiveau());
		title.setFont(new Font("Sans Serif",Font.PLAIN,30));
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		comments.setFont(new Font("Sans Serif",Font.PLAIN,30));
		comments.setHorizontalAlignment(SwingConstants.CENTER);
		comments.setForeground(Color.MAGENTA);
		
		//panel Laby
			//grid layout
		GridLayout grid= new GridLayout(laby.getTailleY(), laby.getTailleX()); 
		panelLaby.setLayout(grid);
			//creation matrice
		matrice=new JButton[laby.getTailleY()][laby.getTailleX()];
		for(int i=0; i<laby.getTailleY();i++){
			for(int j=0; j<laby.getTailleX();j++){
				matrice[i][j]=new JButton();
				matrice[i][j].setBackground(Color.white);
				matrice[i][j].setIcon(laby.getCases()[i][j].getIcon());
				panelLaby.add(matrice[i][j]);
			}
		}
		//set fish 
		matrice[laby.getCurrentPosY()][laby.getCurrentPosX()].setIcon(fish);
		//set p�pite d'or
		matrice[laby.getEndY()][laby.getEndX()].setIcon(or);
		//panel Action
			//flow layout
		FlowLayout flow= new FlowLayout();
		panelAction.setLayout(flow);
		panelAction.setBackground(Color.white);

			//creation autres boutons
		panelAction.add(upButton);
		panelAction.add(downButton);
		panelAction.add(leftButton);
		panelAction.add(rightButton);
		panelAction.add(robotButton);
		panelAction.add(smartButton);
			//design boutons
		upButton.setBackground(Color.GREEN);
		downButton.setBackground(Color.GREEN);
		leftButton.setBackground(Color.GREEN);
		rightButton.setBackground(Color.GREEN);
		robotButton.setBackground(Color.CYAN);
		smartButton.setBackground(Color.CYAN);
		
			// add Action Listener 
		upButton.addActionListener(this);
		downButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		robotButton.addActionListener(this);
		smartButton.addActionListener(this);
		//build frame
		build();
	}
	
	/** Set window properties
	 */
	private void build()
	{
		setTitle("Labyrinthe");//titre de la fenetre
		setSize(900,900);//dimensions de la fenetre
		setLocationRelativeTo(null);//positionnement au centre de l'ecran
		setResizable(true);// pas de redimensionnement possible
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fenetre se ferme par appuye sur croix
		setContentPane(panelMain);
	}
	
	/**move fish up
	 * @return true if moved, false otherwise
	 */
	public boolean moveUp()
	{
		int x=laby.getCurrentPosX();
		int y=laby.getCurrentPosY();
		boolean moved=laby.move(laby.getCurrentPosY()-1, laby.getCurrentPosX());
		if(moved){
			matrice[y][x].setIcon(laby.getCases()[y][x].getIcon());
			matrice[y-1][x].setIcon(fish);
			compteur++;
			return true;
		}
		else {
			comments.setText("Can't move there !");
			return false;
		}
	}
	/**move fish down
	 * @return true if moved, false otherwise
	 */
	public boolean moveDown()
	{
		int x=laby.getCurrentPosX();
		int y=laby.getCurrentPosY();
		boolean moved=laby.move(laby.getCurrentPosY()+1, laby.getCurrentPosX());
		if(moved){
			matrice[y][x].setIcon(laby.getCases()[y][x].getIcon());
			matrice[y+1][x].setIcon(fish);
			compteur++;
			return true;
		}
		else {
			comments.setText("Can't move there !");
			return false;
		}
	}
	/**move fish right
	 * @return true if moved, false otherwise
	 */
	public boolean moveRight()
	{
		int x=laby.getCurrentPosX();
		int y=laby.getCurrentPosY();
		boolean moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()+1);
		if(moved){
			matrice[y][x].setIcon(laby.getCases()[y][x].getIcon());
			matrice[y][x+1].setIcon(fish);
			compteur++;
			return true;
		}
		else {
			comments.setText("Can't move there !");
			return false;
		}
	}
	/**move fish left
	 * @return true if moved, false otherwise
	 */
	public boolean moveLeft()
	{
		int x=laby.getCurrentPosX();
		int y=laby.getCurrentPosY();
		boolean moved=laby.move(laby.getCurrentPosY(), laby.getCurrentPosX()-1);
		if(moved){
			matrice[y][x].setIcon(laby.getCases()[y][x].getIcon());
			matrice[y][x-1].setIcon(fish);
			compteur++;
			return true;
		}	
		else {
			comments.setText("Can't move there !");
			return false;
		}
	}

	/** r�soud labyrinthe automatique
	 */
	public void robot()
	{
		int Max=3, Min=0;
		
		
		while(!laby.isWin()){
			
			boolean moved=false;
			
			while(!moved){
				
				int rdm = Min + (int)(Math.random() * ((Max - Min) + 1));
				if (rdm == 0)
					{moved = moveUp();}
				else if(rdm == 1)
					{moved = moveDown();}
				else if(rdm == 2)
					{moved = moveRight();}
				else if(rdm == 3)
					{moved = moveLeft();}
				
				if(moved) {
					System.out.println("MOVED");
					// sleep 1 second
//					try {
//						TimeUnit.MILLISECONDS.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}			
		}
		if(laby.isWin()){
			System.out.println("gagne !!");
			System.out.println("Nombre de coups: "+compteur);
			comments.setText("Gagn� !!! En "+compteur+" coups");
		}
	}
	
	/* handles button actions
	 */
	public void actionPerformed(ActionEvent e)
	{
		Object source= e.getSource();
		if(source == upButton)
		{
			System.out.println("up !");
			moveUp();
		}
		else if(source == downButton)
		{
			System.out.println("down !");
			moveDown();
		}
		else if(source == rightButton)
		{
			System.out.println("right !");
			moveRight();
			
		}
		else if(source == leftButton)
		{
			System.out.println("left !");
			moveLeft();
			
		}
		else if(source == robotButton)
		{
			System.out.println("robot !");
			robot();
		}
		else if(source == smartButton)
		{
			System.out.println("smart !");
		}
		
		if(laby.isWin()){
			System.out.println("gagne !!");
			System.out.println("Nombre de coups: "+compteur);
			comments.setText("Gagn� !!! En "+compteur+" coups");
			

		}
			
	}

}
