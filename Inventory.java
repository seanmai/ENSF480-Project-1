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

public class Inventory{
	private ArrayList<Document> documents;
	private static Inventory single_inventory = null;
	
	public static Inventory getInstance() 
    { 
        if (single_inventory == null) 
		{
            single_inventory = new Inventory(); 
		}
  
        return single_inventory; 
    }
	
	private Inventory()
	{
		documents = new ArrayList<Document>();
	}
	
	public void display()
	{
		for(int i = 0; i < single_inventory.documents.size(); i++)
		{
			single_inventory.documents.get(i).display();
		}
	}
	
	public ArrayList<Document> getDocuments()
	{
		return single_inventory.documents;
	}
	
	public static int getSize() {
		return single_inventory.documents.size();
	}
}