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
    private void addToCart(Document doc);
    private void searchDocument(String name);
    private void placeOrder(ArrayList<Documents> cart);
}
