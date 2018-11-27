import java.util.ArrayList;
import java.util.Scanner;

public class RegisteredBuyerView implements View {

	ArrayList <Promotion> promotions;
//	Subject subject;
	
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
	
	public void displayPromos(){
		for(Promotion p: promotions){
			p.display();
		}
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
		if(option == 1){
			InventoryController inventory = new InventoryController();
			
		}
		
	}
	
	
}
