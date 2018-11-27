/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.util.ArrayList;

public class RegisteredBuyer extends User implements Buyer{

	public RegisteredBuyer(String username, String password, String name){
		this.username = username;
		this.password = password; 
		this.name = name;
		this.type = "R";
	}

	@Override
	public void addToCart(Document doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchDocument(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeOrder(ArrayList<Document> cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePayment() {
		// TODO Auto-generated method stub
		
	}
}

