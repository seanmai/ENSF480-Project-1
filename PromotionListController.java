
import java.util.ArrayList;

public class PromotionListController {

	private PromotionList promos;
	
	public PromotionListController(){
		promos = PromotionList.getInstance();
	}
	
	public void addPromotion(Promotion promo){
		ArrayList<Promotion> promoList = promos.getPromoList();
		promoList.add(promo);
	}
	
	public boolean updatePromotion(Promotion promo){
		ArrayList<Promotion> promoList = promos.getPromoList();
		int index = 0;
		for(Promotion p: promoList){
			if(p.getID() == promo.getID()){
				promoList.set(index, promo);
				return true;
			}
			index++;
		}
		return false;
	}
	
	public boolean removePromotion(Promotion promo){
		ArrayList<Promotion> promoList = promos.getPromoList();
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
	
	public ArrayList<Promotion> getPromotions(){
		ArrayList<Promotion> promoList = promos.getPromoList();
		return promoList;
	}
	
}
