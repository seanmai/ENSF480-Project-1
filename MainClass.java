/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam 10153891
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class MainClass{
	static BufferedReader input;
	
	/**
	* Prints start menu and returns user choice
	* between logging in and continuing as guest user
	 * @throws IOException 
	 * @throws NumberFormatException 
	*/
	public static int startMenu() throws NumberFormatException, IOException
	{
		int n;
		do{
		System.out.println("Please select one of the following:");
		System.out.println("1. Login");
		System.out.println("2. Continue as guest");
		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2);
		return n;
	}
	
	public static void populateDocs(){
		
	}
	public static void populateUsers(){
		UserList theList = UserList.getInstance();
		//theList.addUser(new User());
	}
	
	public static void main(String[] args)
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		populateDocs();
		populateUsers();
		
		int firstOption = 0;
		try {
			firstOption = startMenu();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(firstOption == 1)
		{
			LoginController aController = new LoginController();
			User theUser;
			
			do{
				theUser = aController.logIn();
			}while(theUser == null);
			
			if(theUser.getType().equals("R"))
			{
				System.out.println("registered buyer logged in");
			}
			else if(theUser.getType().equals("O"))
			{
				System.out.println("operator logged in");
			}
		}
		
		else
		{
			System.out.println("browsing as guest");
		}
		
		//reader.close();
	}
}