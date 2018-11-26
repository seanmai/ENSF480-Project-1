
import java.util.ArrayList;

public class PromotionList implements Subject {

	private ArrayList<Promotion> promotions;
	private static PromotionList single_promoList = null;
	private ArrayList<Observer> observers;
	
	private PromotionList(){
		promotions = new ArrayList<Promotion>();
	}
	
	public static PromotionList getInstance(){
		if(single_promoList == null){
			single_promoList = new PromotionList();
		}
		return single_promoList;
	}
	
	public void display(){
		for(int i = 0; i < promotions.size(); i++){
			promotions.get(i).display();
		}
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
	
	public void removePromotion(Promotion promo){
		for(int i = 0; i < promotions.size(); i++){
			if(promotions.get(i).getID() == promo.getID()){
				promotions.remove(i);
			}
		}
		notifyObserver();
	}
	
	public ArrayList<Promotion> getPromoList(){
		return promotions;
	}
	
}
