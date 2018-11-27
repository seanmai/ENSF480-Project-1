/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez 30032154
 * Nov 14, 2018
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckoutView implements View{
    private int selection;
	private Payment payment;

    public void confirmInvoice(ArrayList<Document> cart) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n;
        do{
            double totalPrice = 0;
    		for(int i = 0; i < cart.size(); i++){
                cart.get(i).display();
                totalPrice += cart.get(i).getPrice();
            }
    		System.out.println("----------------------");
    		System.out.println("Total Price: $" + totalPrice);
    		System.out.println("1. Confirm        2. Cancel");
    		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2);
	}

	@Override
	public void display() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name: ");
        payment.setName(input.readLine());
        System.out.println("Enter your card number: ");
        payment.setCardInfo(input.readLine());
		System.out.println("Enter your address: ");
        payment.setAddress(input.readLine());
	}

    public int getSelection() {
		return selection;
	}

	public Payment getPayment() {
		return payment;
	}
}
