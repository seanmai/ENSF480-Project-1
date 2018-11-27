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
					addDoc();
					break;
				case 3:
					deleteDoc();
					break;
				case 4:
					editDoc();
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

	private void deleteDoc() {
		int delID;
		try {
			delID = view.getDocNum();
			if(delID == -1)return;
			else {
				InventoryController aControl = new InventoryController();
				aControl.removeDocument(delID);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void addDoc() {
		try {
			Document toAdd = view.getDocAdd();
			InventoryController aControl = new InventoryController();
			aControl.addDocument(toAdd);
			System.out.println("Successfully added " + toAdd.getTitle() + " to inventory");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void editDoc() {
		int editID;
		try {
			editID = view.getDocNum();
			if(editID == -1)return;
			else {
				InventoryController aControl = new InventoryController();
				Document doc = aControl.searchByID(editID);
				if(doc == null)return;
				
				view.editDoc(doc);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
