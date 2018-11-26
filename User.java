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
    private String username;
    private String password;
    private String name;
    private String type;
	
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
}
