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

	public LoginController()
	{
		users = UserList.getInstance();
		view = new LoginView();
	}

	/**
	* Displays login view and authenticates the user input
	*/
	public User logIn()
	{
			User currentUser;

			view.display();
			String user = view.getUser();
			String pass = view.getPass();
			for(int i = 0; i < users.getUsers().size(); i++)
			{
				currentUser = users.getUsers().get(i);
				if(currentUser.getUsername().equals(user) && currentUser.passwordMatches(pass))
				{
					return currentUser;
				}
			}
			return null;
	}

	/**
	* Authenticate username exists
	* @param user
	*/
	public boolean validateUsername(String user) {
		User currentUser;
		for(int i = 0; i < users.getUsers().size(); i++)
		{
			currentUser = users.getUsers().get(i);
			if(currentUser.getUsername().equals(user))
			{
				return false;
			}
		}
		return true;
	}
}
