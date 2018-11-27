/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam 10153891
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.util.ArrayList;

public class InventoryController{
	
	private Inventory theInv;
	
	public InventoryController()
	{
		theInv = Inventory.getInstance();
	}

	public void addDocument(Document doc){
		ArrayList<Document> docList = theInv.getDocuments();
		docList.add(doc);
    }
    public void updateDocument(Document doc){
		System.out.println("in update document");
    }
    public void removeDocument(Document doc){
		System.out.println("in remove document");
    }
    
    public void displayInventory() {
    	System.out.println("\nInventory contains: \n");
    	theInv.display();
    }

	public ArrayList<Document> search(String searchKey) {
		ArrayList<Document> ret = new ArrayList<Document>();
		Document currentDoc;
		for(int i = 0; i < theInv.getSize(); i++) {
			currentDoc = theInv.getDocuments().get(i);
			if(currentDoc.getAuthor().contains(searchKey) || currentDoc.getTitle().contains(searchKey)) {
				ret.add(currentDoc);
			}
		}
		
		return ret;
	}
}