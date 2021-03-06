/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdinaryBuyerView implements View{

	public int n;

	/**
	* Displays and parses user input for Ordinary Buyer actions
	* @throws NumberFormatException
	* @throws IOException
	*/
	@Override
	public void display() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do{
		System.out.println("Please select one of the following:");
		System.out.println("1. Browse Documents");
		System.out.println("2. Search Documents");
		System.out.println("3. Add To Cart");
		System.out.println("4. View Cart");
		System.out.println("5. Create Account");
		System.out.println("6. Exit");
		n = Integer.parseInt(input.readLine());
		}while(n < 1 || n > 6);

	}

	public int getSelection(){
		return n;
	}

	/**
	* Displays and parses user input for adding to cart action
	* @throws NumberFormatException
	* @throws IOException
	*/
	public void promptItem() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the document number you wish to add to cart:");
		n = Integer.parseInt(input.readLine());
	}

	/**
	* Displays and parses user input for checkout actions
	* @throws NumberFormatException
	* @throws IOException
	*/
	public void promptCart() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do{
		System.out.println("How would you like to proceed? ");
		System.out.println("1. Back To Main Menu");
		System.out.println("2. Proceed To Checkout");
		System.out.println("3. Remove Item");
		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2 && n != 3);
	}

	/**
	* Displays and parses user input for registration action
	* @throws IOException
	*/
	public User promptReg() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		LoginController aControl = new LoginController();
		System.out.println("Enter your name: ");
        String name = input.readLine();
        System.out.println("Enter a username: ");
        String user = input.readLine();
        while(!aControl.validateUsername(user))
        {
        	System.out.println("Name taken! Try again.");
        	System.out.println("Enter a username: ");
            user = input.readLine();
        }
		System.out.println("Enter a password: ");
        String password = input.readLine();

        return new RegisteredBuyer(user, password, name);
	}

	/**
	* Displays and parses user input for search actions
	* @throws NumberFormatException
	* @throws IOException
	*/
	public String promptSearch() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		LoginController aControl = new LoginController();
		System.out.println("Enter search key: ");
        String key = input.readLine();
        return key;
	}

	public int promptCartEdit() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the ID of the document to remove: ");
        int id = Integer.parseInt(input.readLine());

        while(id > Inventory.getInstance().getSize() || id < 0){
        	System.out.println("Invalid book id...");
        	System.out.println("Enter the ID of the document: ");
            id = Integer.parseInt(input.readLine());
        }
        return id;
	}

}
