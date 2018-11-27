import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LoginView implements View{
	
	String enteredUser;
	String enteredPass;
	
	public void display(){   
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter your username:");
			enteredUser = input.readLine();
			System.out.println("Please enter your password:");
			enteredPass = input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUser() {
		return enteredUser;
	}

	public String getPass() {
		return enteredPass;
	}

}
