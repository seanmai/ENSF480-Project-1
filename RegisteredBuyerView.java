import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisteredBuyerView implements View {

	ArrayList<Promotion> promotions;
	private int selection;
	
	public RegisteredBuyerView(){
		promotions = PromotionList.getInstance().getPromoList();
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
		System.out.println("2. Search Document");
		System.out.println("3. View Promotions");
		System.out.println("4. View Cart");
		System.out.println("5. Add to cart");
		System.out.println("6. Checkout");
		System.out.println("7. Unsubscribe");
		System.out.println("8: Exit");
		option = reader.nextInt();
		}while(option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7);
		
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
		inv.displayInventory();
	}
	
	public void viewPromos(){
		PromotionListController promos = new PromotionListController(this);
		promos.displayPromotions();
	}
	
	public void getDocID(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a document ID to add it to cart");
		selection = reader.nextInt();
	}
	
	public String promptSearch() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		LoginController aControl = new LoginController();
		System.out.println("Enter search key: ");
        String key = input.readLine();
        return key;
	}
	
	public void promptCart() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do{
		System.out.println("How would you like to proceed? ");
		System.out.println("1. Back To Main Menu");
		System.out.println("2. Proceed To Checkout");
		selection = Integer.parseInt(input.readLine());
		}while(selection != 1 && selection != 2);
	}
	
	public void promptItem() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the document number you wish to add to cart:");
		selection = Integer.parseInt(input.readLine());		
	}
	
}
