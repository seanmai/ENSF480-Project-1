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

	@Override
	public void display() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do{
		System.out.println("Please select one of the following:");
		System.out.println("1. Browse Documents");
		System.out.println("2. Add To Cart");
		System.out.println("3. View Cart");
		System.out.println("4. Create Account");
		System.out.println("5. Exit");
		n = Integer.parseInt(input.readLine());
		}while(n < 1 || n > 5);
		
	}
	
	public int getSelection(){
		return n;
	}

	public void promptItem() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the document number you wish to add to cart:");
		n = Integer.parseInt(input.readLine());		
	}

	public void promptCart() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do{
		System.out.println("How would you like to proceed? ");
		System.out.println("1. Back To Main Menu");
		System.out.println("2. Proceed To Checkout");
		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2);
	}

	public User promptReg() {
		return null;
	}
    
}
