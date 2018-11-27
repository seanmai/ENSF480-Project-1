
import java.util.ArrayList;

public class PromotionList {

	private ArrayList<Promotion> promotions;
	private static PromotionList single_promoList = null;
//	private ArrayList<Observer> observers;
	
	private PromotionList(){
		promotions = new ArrayList<Promotion>();
	}
	
	public static PromotionList getInstance(){
		if(single_promoList == null){
			single_promoList = new PromotionList();
		}
		return single_promoList;
	}
	
//	public void register(Observer obs){
//		observers.add(obs);
//		obs.update(promotions);
//	}
//
//	@Override
//	public void remove(Observer obs) {
//		observers.add(obs);
//	}
//
//	@Override
//	public void notifyObserver() {
//		for(int i = 0; i < observers.size(); i++){
//			Observer o = observers.get(i);
//			o.update(promotions);
//		}
//	}
	
	public boolean removePromotion(Promotion promo){
		ArrayList<Promotion> promoList = promotions;
		int index = 0;
		for(Promotion p: promoList){
			if(p.getID() == promo.getID()){
				promoList.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}
	
	public void addPromotion(Promotion promo){
		ArrayList<Promotion> promoList = promotions;
		promoList.add(promo);
	}
	
	public ArrayList<Promotion> getPromoList(){
		return promotions;
	}
	
	public void updatePromotion(Promotion promo){
		ArrayList<Promotion> promoList = promotions;
		int index = 0;
		for(Promotion p: promoList){
			if(p.getID() == promo.getID()){
				promoList.set(index, promo);
			}
			index++;
		}
	}
	
}
