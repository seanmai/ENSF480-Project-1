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

public class LoginController{
	
	private UserList users;
	private LoginView view;
	
	public LoginController(LoginView v)
	{
		users = UserList.getInstance();
		view = new LoginView();
	}
	
	public User logIn()
	{
		view.display();
		String user = view.getUser();
		String pass = view.getPass();
		for(int i = 0; i < users.getUsers().size(); i++)
		{
			User currentUser = users.getUsers().get(i);
			if(currentUser.getUsername.equals(user) && currentUser.passwordMatches(pass))
			{
				return currentUser;
			}
		}
		return null; 
	}
}