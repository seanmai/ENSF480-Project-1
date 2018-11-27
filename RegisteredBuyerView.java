import java.util.ArrayList;
import java.util.Scanner;

public class RegisteredBuyerView implements View {

	ArrayList<Promotion> promotions;
	ArrayList<Document> inventory;
	private int selection;
	
	public RegisteredBuyerView(){
		
	}
	
	public void update(ArrayList<Promotion> promos) {
		int previousSize = promotions.size();
		this.promotions = promos;
		if(previousSize > promotions.size()){
			displayNotification();
		}
	}
	
	public void displayNotification(){
		System.out.println("New promotions available! \n");
	}
	
	
	@Override
	public void display(){
		int option;
		do{
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter one of the following options to proceed: " );
		System.out.println("1. Browse");
		System.out.println("2. View Promotions");
		System.out.println("3. Checkout");
		option = reader.nextInt();
		}while(option != 1 && option != 2 && option != 3);
		
		selection = option;
		
	}

	public int getSelection() {
		return selection;
	}

	public void setSelection(int selection) {
		this.selection = selection;
	}
	
	public void browse(){
		InventoryController inv = new InventoryController();
		do{
			inv.displayInventory();
			Scanner reader = new Scanner(System.in);
			System.out.println("Please enter one of the following options: ");
			System.out.println("1. Enter a document ID to add it to cart");
			System.out.println("2. Exit");
			selection = reader.nextInt();
		} while(selection != 1 && selection != 2);
	}
	
	public void viewPromos(){
		PromotionListController promos = new PromotionListController(this);
		promos.displayPromotions();
	}
	
	public void checkout(){
		
	}
	
	public void getDocID(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a document ID to add it to cart");
		selection = reader.nextInt();
	}
	
	
}
