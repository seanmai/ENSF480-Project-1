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
}

