/**
 * 
 */
package Controler;

import java.util.Scanner;

/**
 * @author kathr
 *
 */
public class Game {
	
	public static void main(String[] args)
	{
		static Scanner userInput =new Scanner(System.in);
		
		System.out.println("Choisissez un niveau:");
		System.out.println("1: niveau 1");
		System.out.println("2: niveau 2");
		System.out.println("3: niveau 3");
		if(userInput.hasNextInt())
		{
			int niveau=userInput.nextInt();
			switch(niveau){
				case 1: //open file niveau1.txt
					break;
				case 2: // open file niveau2.txt
					break;
				case 3: //open file niveau3.txt
					break;
			}
	
			
		}
		
	}

}
