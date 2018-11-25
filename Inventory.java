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
		for(int i = 0; i < documents.size(); i++)
		{
			System.out.println("display doc");
		}
	}
	
	public ArrayList<Document> getDocuments()
	{
		return documents;
	}
}