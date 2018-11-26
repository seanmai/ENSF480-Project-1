import java.io.IOException;

/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez 30032154
 * Nov 14, 2018
 *
 */

public class OperatorController {
	
	private User user;
	private OperatorView view;
	
	public OperatorController(User user) {
		this.user = user;
		view = new OperatorView();
	}
	
	public void runSession()
	{
		int selection = 0;
		do {
			try {
				view.display();
				selection = view.getSelection();
				
				switch(selection) {
				case 1:
					InventoryController aControl = new InventoryController();
					aControl.displayInventory();
					break;
				case 2:
					System.out.println("add add logic");
					break;
				case 3:
					System.out.println("add delete logic");
					break;
				case 4:
					System.out.println("add edit logic");
					break;
				case 5:
					break;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}while(selection != 5);
	}

}
