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
		return users;
	}
}