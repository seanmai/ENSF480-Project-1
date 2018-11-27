/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez 30032154
 * Nov 14, 2018
 *
 */

import java.io.IOException;

public class CheckoutController  {
	private Payment payment;
	private CheckoutView view;
    private ArrayList<Document> cart;

	public CheckoutController(ArrayList<Document> cart){
		this.cart = cart;
	}

	public void runSession(){
        int selection = 0;
		try {
			view.confirmInvoice();
			selection = view.getSelection();

			switch(selection) {
			case 1:
                try {
                    view.display();
                    payment = view.getPayment();
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
				break;
			case 2:
				System.out.println("add cancel logic");
				break;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
