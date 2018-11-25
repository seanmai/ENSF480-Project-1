
import java.util.ArrayList;

public class PromotionList implements Subject {

	ArrayList<Promotion> promotions;
	ArrayList<Observer> observers;
	
	public PromotionList(){
		promotions = new ArrayList<Promotion>();
		observers = new ArrayList<Observer>();
	}
	
	public void register(Observer obs){
		observers.add(obs);
		obs.update(promotions);
	}

	@Override
	public void remove(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size(); i++){
			Observer o = observers.get(i);
			o.update(promotions);
		}
	}
	
	public void removePromotions(Promotion promo){
		for(int i = 0; i < promotions.size(); i++){
			if(promotions.get(i).getID() == promo.getID()){
				promotions.remove(i);
			}
		}
		notifyObserver();
	}
	
}
