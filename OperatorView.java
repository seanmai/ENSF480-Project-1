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
		System.out.println("5. Edit Promotion");
		System.out.println("6. Add Promotion");
		System.out.println("7: Delete Promotion");
		System.out.println("8. Exit");
		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2 && n != 3 && n != 4 && n != 5 && n != 6 && n != 7);
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
	
	public Promotion getPromotionAdd() throws NumberFormatException, IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Start date:");
		System.out.println("Enter day:");
        int day1 = Integer.parseInt(input.readLine());
        System.out.println("Enter month:");
        int month1 = Integer.parseInt(input.readLine());
        System.out.println("Enter year: ");
        int year1 = Integer.parseInt(input.readLine());
		System.out.println("End date: ");
		System.out.println("Enter day:");
        int day2 = Integer.parseInt(input.readLine());
        System.out.println("Enter month:");
        int month2 = Integer.parseInt(input.readLine());
        System.out.println("Enter year: ");
        int year2 = Integer.parseInt(input.readLine());
        System.out.println("Enter description");
        String description = input.readLine();
        return new Promotion(day1, month1, year1, day2, month2, year2, description);
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
	
	public int getPromoNum() throws NumberFormatException, IOException {
		String result;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the ID of the promotion: ");
        int id = Integer.parseInt(input.readLine());
        
        while(id >= PromotionList.getInstance().getPromoList().size() || id < 0){
        	System.out.println("Invalid promotion id...");
        	System.out.println("Or type \"exit\" to go back");
        	System.out.println("Enter the ID of the promotion: ");
        	result = input.readLine();
        	if(result.equals("exit"))return -1;
            id = Integer.parseInt(result);
        }
        return id;
	}

	public void editPromo(Promotion promo) throws IOException{
		String resp;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("Current start date: " + promo.getStartDate());
		System.out.println("Edit start date? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New start date: ");
        	System.out.println("Enter day:");
            int day1 = Integer.parseInt(input.readLine());
            System.out.println("Enter month:");
            int month1 = Integer.parseInt(input.readLine());
            System.out.println("Enter year: ");
            int year1 = Integer.parseInt(input.readLine());
            promo.setStartDate(day1, month1, year1);
        }
        
		System.out.println("Current end date: " + promo.getEndDate());
		System.out.println("Edit end date? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	System.out.println("New end date: ");
        	System.out.println("Enter day:");
            int day1 = Integer.parseInt(input.readLine());
            System.out.println("Enter month:");
            int month1 = Integer.parseInt(input.readLine());
            System.out.println("Enter year: ");
            int year1 = Integer.parseInt(input.readLine());
            promo.setEndDate(day1, month1, year1);
        }
        
		System.out.println("Current description: " + promo.getStartDate());
		System.out.println("Edit description? (type y for yes)");
        resp = input.readLine();
        if(resp.equals("y")) {
        	promo.setDescription(resp);
        }
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

