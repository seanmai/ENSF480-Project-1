/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.util.ArrayList;

public class Operator {
	
    public void addDocument(Document doc){
		Inventory.getInstance().addDocument(doc);
    }
    public void updateDocument(Document doc){
		Inventory.getInstance().updateDocument(doc);
    }
    public void removeDocument(Document doc){
		Inventory.getInstance().removeDocument(doc);
    }
}
