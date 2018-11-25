/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam 10153891
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.util.Scanner;
 
public class MainClass{
	
	public int startMenu()
	{
		Scanner reader = new Scanner(System.in);
		int n;
		do{
		System.out.println("Please select one of the following:");
		System.out.println("1. Login");
		System.out.println("2. Continue as guest");
		n = reader.nextInt();
		}while(n != 1 && n != 2);
		reader.close();
		
		return n;
	}
	
	public static void main(String args)
	{
		Scanner reader = new Scanner(System.in);
		
		int firstOption = startMenu();
		if(firstOption == 1)
		{
			LoginController aController = new LoginController();
			User theUser;
			
			do{
				theUser = aController.logIn();
			}while(theUser == null);
			
			if(theUser.getType().equals("R"))
			{
				
			}
			else if(theUser.getType().equals("O"))
			{
				
			}
		}
		
		else
		{
		}
		
		reader.close();
	}
}