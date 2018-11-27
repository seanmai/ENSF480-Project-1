import java.io.IOException;
import java.util.ArrayList;

public class OrdinaryBuyerController {

	OrdinaryBuyerView view;
	ArrayList<Document> cart;
	int selection;

	public OrdinaryBuyerController() {
		view = new OrdinaryBuyerView();
		cart = new ArrayList<Document>();
	}

	/**
	* Controller for ordinary buyer actions
	* @throws NumberFormatException
	* @throws IOException
	*/
	public void runSession()
	{
		selection = 0;
		do {
			try {
				view.display();
				selection = view.getSelection();

				switch(selection) {
				case 1:
					InventoryController aControl = new InventoryController();
					aControl.displayInventory();
					break;
				case 2:
					searchDocs();
					break;
				case 3:
					InventoryController aControl = new InventoryController();
					aControl.displayInventory();
					addDocToCart();
					break;
				case 4:
					displayCart();
					cartMenu();
					break;
				case 5:
					registration();
					break;
				case 6:
					break;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(selection != 5 && selection != 6);
	}

	/**
	* displays items in cart
	*/
	private void displayCart() {

		System.out.println("Cart Contains:");
		for(int i = 0; i < cart.size(); i++) {
			cart.get(i).display();
		}
		System.out.println();
	}

	/**
	* adds a document to the cart
	*/
	private void addDocToCart() {
		try {
			view.promptItem();
			selection = view.getSelection();
			while(selection < 0 || selection > Inventory.getSize())
			{
				System.out.println("Invalid document number! Try again...");
				view.promptItem();
				selection = view.getSelection();
			}
			Inventory theInv = Inventory.getInstance();
			Document toAdd = theInv.getDocuments().get(selection);

			if(toAdd.getQuantity() <= 0) {
				System.out.println("Document out of stock.");
				return;
			}
			cart.add(toAdd);
			System.out.println("\"" + toAdd.getTitle() + "\"" + " successfully added to cart.\n");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	* handles cart menu actions
	*/
	private void cartMenu() {
		try {
			view.promptCart();
			selection = view.getSelection();

			if(selection == 1)return;
			else {
				CheckoutController checkoutCtrl = new CheckoutController(cart);
				checkoutCtrl.runSession();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	* handles registration
	*/
	private void registration() {
		try {
			User u = view.promptReg();
			UserList.getInstance().addUser(u);
			System.out.println("Account created successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	* handles document searches
	*/
	private void searchDocs() {
		try {
			String searchKey = view.promptSearch();
			InventoryController inv = new InventoryController();
			ArrayList<Document> results = inv.search(searchKey);
			if(results.size() <= 0) {
				System.out.println("\nNo results found for search \"" + searchKey + "\"\n");
			}
			else {
				System.out.println("\nSearch results:");
				for(int i = 0; i < results.size(); i++) {
					results.get(i).display();
				}
				System.out.println();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
