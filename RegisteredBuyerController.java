import java.io.IOException;
import java.util.ArrayList;

public class RegisteredBuyerController {

	private ArrayList<Document> shoppingCart;
	private RegisteredBuyer user;
	private RegisteredBuyerView view;
	int selection;
	
	public RegisteredBuyerController(User user){
		this.user = (RegisteredBuyer) user;
		view = new RegisteredBuyerView();
		shoppingCart = new ArrayList<Document>();
	}
	
	public void runSession() {
		selection = 0;
		do {
			view.display();
			selection = view.getSelection();
			
			switch (selection) {
			case 1:
				browse();
				break;
			case 2:
				searchDocs();
				break;
			case 3:
				view.viewPromos();
				break;
			case 4:
				viewCart();
				cartMenu();
				break;
			case 5: 
				addToCart();
				break;
			case 6:
				checkout();
				break;
			case 7: 
				unsubscribe();
				break;
			case 8: 
				break;
			}
		} while (selection != 4 && selection != 5 && selection != 7 && selection != 8);
	}
	
	public void browse(){
		view.browse();
	}
	
	public void addToCart(){
		
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
			shoppingCart.add(toAdd);
			System.out.println("\"" + toAdd.getTitle() + "\"" + " successfully added to cart.\n");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void unsubscribe(){
		UserList list = UserList.getInstance();
		ArrayList<User> users = list.getUsers();
		int index = 0;
		for(User u: users){
			if(user.getUsername() == u.getUsername()){
				users.remove(index);
				System.out.println("Unsubscription was successful");
				OrdinaryBuyerController c = new OrdinaryBuyerController();
				c.runSession();
			}
			index++;
		}
		
	}
	
	public void viewCart(){
		System.out.println("Items in your cart:");
		int total = 0;
		for(Document doc: shoppingCart){
			doc.display();
			total += doc.getPrice();
		}
		System.out.println("Total:  $" + total);
	}
	
	public void checkout(){
		CheckoutController checkout = new CheckoutController(shoppingCart);
		checkout.runSession();
	}
	
	private void searchDocs() {
		try {
			String searchKey = view.promptSearch();
			System.out.println("add search logic " + searchKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cartMenu() {
		try {
			view.promptCart();
			selection = view.getSelection();

			if(selection == 1)return;
			else {
				CheckoutController checkoutCtrl = new CheckoutController(shoppingCart);
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
	
}
