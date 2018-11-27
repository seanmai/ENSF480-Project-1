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
		InventoryController invControl = new InventoryController();
		Document d1 = new Document("Waf", "My Book", 15, "Book", 200, 20);
		invControl.addDocument(d1);
	}
	public static void populateUsers(){
		UserList theList = UserList.getInstance();
		Operator o1 = new Operator("wafa.anam", "pass", "Wafa");
		theList.addUser(o1);
		RegisteredBuyer r1 = new RegisteredBuyer("buyer", "p", "reg");
		theList.addUser(r1);
	}

	public static void populatePromotions(){
		PromotionListController promo = new PromotionListController();
		Promotion promotion = new Promotion(26, 11, 2018, 30, 11, 2018, "All books bogo");
		promo.addPromotion(promotion);
	}

	public static void main(String[] args)
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		populateDocs();
		populateUsers();
		populatePromotions();


		int firstOption = 0;

		do {
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
					RegisteredBuyerController rControl = new RegisteredBuyerController(theUser);
					rControl.runSession();
				}
				else if(theUser.getType().equals("O"))
				{
					System.out.println("operator logged in");
					OperatorController aControl = new OperatorController(theUser);
					aControl.runSession();
				}
			}

			else
			{
				System.out.println("browsing as guest");
			}
		}while(true);

//		try {
//			input.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
