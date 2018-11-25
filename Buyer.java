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

public interface Buyer{
    public void addToCart(Document doc);
    public void searchDocument(String name);
    public void placeOrder(ArrayList<Document> cart);
    public void makePayment();
}
