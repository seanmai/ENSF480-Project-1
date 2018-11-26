/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez 30032154
 * Nov 14, 2018
 *
 */

import java.io.*;
import java.util.*;

public abstract class User{
    protected String username;
    protected String password;
    protected String name;
    protected String type;
	
	public String getType(){
		return type; 
	}

	public String getUsername() {
		return username;
	}

	public boolean passwordMatches(String pass) {
		if(password.equals(pass))return true;
		return false;
	}
	
	public void display()
	{
		System.out.println(name + " " + username + " type: " + type);
	}
}
