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
    private int n;
	private Payment payment;

    public void confirmInvoice(ArrayList<Document> cart) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
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
		payment = new Payment();
		System.out.println("Enter your name: ");
        payment.setName(input.readLine());
        System.out.println("Enter your card number: ");
        payment.setCardInfo(input.readLine());
		System.out.println("Enter your address: ");
        payment.setAddress(input.readLine());
	}

    public void displayReceipt(Order order){
        System.out.println("Order confirmed!");
        System.out.println("--------------------------------");
        double totalPrice = 0;
        for(int i = 0; i < order.getItems().size(); i++){
            System.out.println(order.getItems().get(i).getTitle() + "        " + order.getItems().get(i).getPrice());
            totalPrice += order.getItems().get(i).getPrice();
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println("Name: " + order.getName());
        System.out.println("Address: " + order.getAddress());
        System.out.println("Credit Card: " + order.getCardInfo());
    }

    public int getSelection() {
		return n;
	}

	public Payment getPayment() {
		return payment;
	}
}
