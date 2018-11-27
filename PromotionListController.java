
import java.util.ArrayList;

public class PromotionListController {

	private PromotionList promos;
	private RegisteredBuyerView view;
	
	public PromotionListController(View v){
		promos = PromotionList.getInstance();
		view = (RegisteredBuyerView) v;
	}
	
	public PromotionListController(){
		promos = PromotionList.getInstance();
	}
	
	public void addPromotion(Promotion promo){
		promos.getPromoList().add(promo);
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
	
	public void removePromotion(Promotion promo){
		if(promos.removePromotion(promo)){
			updateView();
		}
	}
	
	public void updateView(){
		view.update(promos.getPromoList());
	}
	
	public void displayPromotions(){
		//promos.display();
	}
	
}
