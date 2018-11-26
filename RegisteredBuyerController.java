
public class RegisteredBuyerController {

	private RegisteredBuyer user;
	private RegisteredBuyerView view;
	
	public RegisteredBuyerController(User user){
		this.user = (RegisteredBuyer) user;
		view = new RegisteredBuyerView();
	}
	
	public void runSession(){
		
	}
	
}
