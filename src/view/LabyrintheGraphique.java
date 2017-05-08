/**
 * 
 */
package view;
import javax.swing.*;
import java.awt.event.*;
import model.Labyrinthe;

/**
 * @author kathr
 *
 */
public class LabyrintheGraphique extends JFrame implements ActionListener{
	
	static Labyrinthe laby;
	JPanel panel= new JPanel();
	// contient grille labyrinthe, boutons dir, boutons robot et smart
	static JButton upButton= new JButton("UP");
	static JButton downButton= new JButton("DOWN");
	static JButton leftButton= new JButton("LEFT");
	static JButton rightButton= new JButton("RIGHT");
	static JButton robotButton= new JButton("ROBOT");
	static JButton smartButton= new JButton("SMART");
	
	public LabyrintheGraphique(Labyrinthe lab)
	{
		super();
		
		laby=lab;
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JLabel label= new JLabel("Bienvenue dans le jeu du labyrinthe");
		panel.add(label);
		panel.add(upButton);
		panel.add(downButton);
		panel.add(leftButton);
		panel.add(rightButton);
		panel.add(robotButton);
		panel.add(smartButton);
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
		setLocationRelativeTo(null);//positionnement au centre de l'écran
		setResizable(false);// pas de redimensionnement possible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fenetre se ferme par appuye sur croix
		setContentPane(panel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source= e.getSource();
		if(source == upButton)
		{
			System.out.println("up !");
		}
		else if(source == downButton)
		{
			System.out.println("down !");
		}
		else if(source == rightButton)
		{
			System.out.println("right !");
		}
		else if(source == leftButton)
		{
			System.out.println("left !");
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
