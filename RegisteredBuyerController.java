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
				view.checkout();
				break;
			}
			Scanner reader = new Scanner(System.in);
			System.out.println("Please enter one of the options below: ");
			System.out.println("1. Back to options menu");
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
		shoppingCart.add(inv.getDocuments().get(id));
	}
	
}
