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

public class UserList{

	private ArrayList<User> users;
	private static UserList single_list = null;

	/**
	* returns singleton user list
	*/
	public static UserList getInstance()
    {
        if (single_list == null)
		{
            single_list = new UserList();
		}

        return single_list;
    }

	private UserList()
	{
		users = new ArrayList<User>();
	}

	public ArrayList<User> getUsers()
	{
		return single_list.users;
	}

	/**
	* adds user to list
	* @param user
	*/
	public void addUser(User u)
	{
		single_list.users.add(u);
	}

	/**
	* displays all users in list
	*/
	public void display()
	{
		for(int i = 0; i < single_list.users.size(); i++)
		{
			single_list.users.get(i).display();
		}
	}
}
