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
import java.util.Scanner;

public class OrdinaryBuyer implements Buyer{

    private RegisteredBuyer register(){

    }

    public void viewDocuments(){
        Scanner reader = new Scanner(System.in);
		int n;
		do{
            for(int i = 0; i < documents.size(); i++){
                System.out.println("Select from the following");
        		System.out.println("[" + i + "]" + documents.get(i).getTitle());
        	}
    		n = reader.nextInt();
        } while(n < 0 && n > i);
		reader.close();
        documents.get(n).display();
    }

   private RegisteredBuyer register(){
       return null;
   }


	@Override
	public void addToCart(Document doc) {

	}

	@Override
	public void searchDocument(String name) {

	}

	public void placeOrder(ArrayList<Document> cart) {

	}

	@Override
	public void makePayment() {

	}
}
