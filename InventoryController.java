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

	/**
	* adds document to inventory
	* @param doc
	*/
	public void addDocument(Document doc){
		ArrayList<Document> docList = theInv.getDocuments();
		docList.add(doc);
    }

	/**
	* updates document in the inventory
	* @param doc
	*/
    public void updateDocument(Document doc){
		System.out.println("in update document");
    }

	/**
	* deletes a document from the inventory
	* @param id
	*/
    public void removeDocument(int id){
		for(int i = 0; i < Inventory.getSize(); i++) {
			if(theInv.getDocuments().get(i).getID() == id) {
				theInv.getDocuments().remove(i);
			}
		}
    }

	/**
	* displays list of documents in inventory
	*/
    public void displayInventory() {
    	System.out.println("\nInventory contains: \n");
    	theInv.display();
    }

	/**
	* Queries for documents containing a key matching an author or title
	* @param searchKey
	*/
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

	/**
	* returns document with matching id or null
	* @param id
	*/
	public Document searchByID(int id) {
		Document currentDoc;
		for(int i = 0; i < theInv.getSize(); i++) {
			currentDoc = theInv.getDocuments().get(i);
			if(currentDoc.getID() == id) {
				return currentDoc;
			}
		}

		return null;
	}
}
