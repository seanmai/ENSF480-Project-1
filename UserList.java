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
	
	public void addUser(User u)
	{
		single_list.users.add(u);
	}
	
	public void display()
	{
		for(int i = 0; i < single_list.users.size(); i++)
		{
			single_list.users.get(i).display();
		}
	}
}