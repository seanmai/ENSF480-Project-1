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
	
    public void unsubscribe(){
        
    }
    public void viewPromos(){
    	
    }
    
    public void addToCart(Document doc){
    	
    }
    public void searchDocument(String name){
    	
    }
    public void placeOrder(ArrayList<Document> cart){
    	
    }
    public void makePayment(){
    	
    }
}

