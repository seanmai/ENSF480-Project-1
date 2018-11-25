import java.util.ArrayList;

public class RegisteredBuyerView implements Observer {

	
	
	@Override
	public void update(ArrayList<Promotion> promos) {
		this.promotions = promos;
		viewPromos();
	}

    public void viewPromos(){
    	for(int i = 0; i < promotions.size(); i++){
    		System.out.println(promotions.get(i));
    	}
    }
	
}
