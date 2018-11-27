import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperatorView implements View{

	private int selection;
	
	@Override
	public void display() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n;
		do{
		System.out.println("Please select one of the following:");
		System.out.println("1. Browse Documents");
		System.out.println("2. Add Document");
		System.out.println("3. Delete Document");
		System.out.println("4. Edit Document");
		System.out.println("5. Exit");
		n = Integer.parseInt(input.readLine());
		}while(n != 1 && n != 2 && n != 3 && n != 4 && n != 5);
		
		selection = n;
	}

	public int getSelection() {
		return selection;
	}
}
