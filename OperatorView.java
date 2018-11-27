import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperatorView implements View{

	private int n;
	
	@Override
	public void display() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do{
		System.out.println("Please select one of the following:");
		System.out.println("1. Browse Documents");
		System.out.println("2. Add Document");
		System.out.println("3. Delete Document");
		System.out.println("4. Edit Document");
		System.out.println("5. Exit");
		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2 && n != 3 && n != 4 && n != 5);
	}

	public int getSelection() {
		return n;
	}

	public Document getDocAdd() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Book title: ");
        String title = input.readLine();
        System.out.println("Author: ");
        String author = input.readLine();
		System.out.println("Number of Pages: ");
        int pages = Integer.parseInt(input.readLine());
        System.out.println("Type: ");
        String type = input.readLine();
        System.out.println("Quantity: ");
        int quantity = Integer.parseInt(input.readLine());
        System.out.println("Price: ");
        int price = Integer.parseInt(input.readLine());
        
        return new Document(author, title, pages, type, quantity, price);
	}

	public int getDocNum() throws NumberFormatException, IOException {
		String result;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the ID of the document: ");
        int id = Integer.parseInt(input.readLine());
        
        while(id > Inventory.getInstance().getSize() || id < 0){
        	System.out.println("Invalid book id...");
        	System.out.println("Or type \"exit\" to go back");
        	System.out.println("Enter the ID of the document: ");
        	result = input.readLine();
        	if(result.equals("exit"))return -1;
            id = Integer.parseInt(result);
        }
        return id;
	}

	public void editDoc(Document doc) throws IOException {
		String resp;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Current book title: " + doc.getTitle());
		System.out.println("Edit title? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New title: ");
            doc.setTitle(input.readLine());
        }
        
        System.out.println("Current book author: " + doc.getAuthor());
		System.out.println("Edit author? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New author: ");
            doc.setAuthor(input.readLine());
        }
        
        System.out.println("Current book pages: " + doc.getPages());
		System.out.println("Edit pages? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New pages: ");
            doc.setPages(Integer.parseInt(input.readLine()));
        }
        
        System.out.println("Current book price: " + doc.getPrice());
		System.out.println("Edit price? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New price: ");
        	System.out.println("CHANGE DOC PRICE");
            //doc.setPrice(Double.parseDouble(input.readLine()));
        }
        
        System.out.println("Current book quantity: " + doc.getQuantity());
		System.out.println("Edit quantity? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New quantity: ");
            doc.setQuantity(Integer.parseInt(input.readLine()));
        }
		
        System.out.println("New document details: ");
        doc.display();
	}
}

