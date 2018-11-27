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
import java.util.ArrayList;

public class CheckoutController  {
	private Order order;
	private CheckoutView view;
    private ArrayList<Document> cart;

	/**
	* CheckoutController constructor
	*/
	public CheckoutController(ArrayList<Document> cart){
		this.cart = cart;
		view = new CheckoutView();
	}

	/**
	* Runs checkout controller functions
	* @throws NumberFormatException
	* @throws IOException
	*/
	public void runSession(){
        int selection = 0;
		try {
			view.confirmInvoice(cart);
			selection = view.getSelection();

			switch(selection) {
			case 1:
				view.display();
				order = view.getOrder();
				Inventory inv = Inventory.getInstance();
				for(int i = 0; i < order.getItems.size(); i++){
					for(int j = 0; j < inv.getDocuments(); j++){
						if(order.getItems.at(i).getID() == inv.getDocuments.at(j).getID()){
							inv.getDocuments.at(j).setQuantity = (inv.getDocuments.at(j).getQuantity - 1);
						}
					}
				}
				view.displayReceipt(order);
				break;
			case 2:
				System.out.println("exit");
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
