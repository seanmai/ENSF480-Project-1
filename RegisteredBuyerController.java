import java.util.Scanner;
import java.util.ArrayList;

public class RegisteredBuyerController {

	private ArrayList<Document> shoppingCart;
	private RegisteredBuyer user;
	private RegisteredBuyerView view;
	
	public RegisteredBuyerController(User user){
		this.user = (RegisteredBuyer) user;
		view = new RegisteredBuyerView();
		shoppingCart = new ArrayList<Document>();
	}
	
	public void runSession() {
		int answer;
		do {
			view.display();
			int selected = view.getSelection();
			switch (selected) {
			case 1:
				browse();
				break;
			case 2:
				view.viewPromos();
				break;
			case 3:
				viewCart();
				break;
			case 4:
				checkout();
				break;
			case 5: 
				unsubscribe();
				break;
			case 6: 
				break;
			}
			Scanner reader = new Scanner(System.in);
			System.out.println("Please enter one of the options below: ");
			System.out.println("1. Back To Main Menu");
			System.out.println("2. Exit");
			answer = reader.nextInt();
		} while (answer == 1);
	}
	
	public void browse(){
		int answer;
		do{
			view.browse();
			answer = view.getSelection();
			if(answer != 2){
				view.getDocID();
				int id = view.getSelection();
				addToCart(id);
			}
		}while(answer != 2);
	}
	
	public void addToCart(int id){
		Inventory inv = Inventory.getInstance();
		while(id < 0 || id >= inv.getDocuments().size()){
			System.out.println("Invalid input. Please try again");
			view.getDocID();
		}
		Document doc = inv.getDocuments().get(id);
		if(doc.getQuantity() <= 0){
			System.out.println("Document is out of stock");
		}else{
			shoppingCart.add(doc);
			System.out.println("\""+ doc.getTitle() + "\""+ " was added to your cart successfully");
		}
	}
	
	public void unsubscribe(){
		UserList list = UserList.getInstance();
		ArrayList<User> users = list.getUsers();
		int index = 0;
		for(User u: users){
			if(user.getUsername() == u.getUsername()){
				users.remove(index);
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
		System.out.println("Total:   $" + total);
	}
	
	public void checkout(){
		CheckoutController checkout = new CheckoutController(shoppingCart);
		checkout.runSession();
	}
	
}
