/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.util.ArrayList;

public class Operator extends User{
	
	public Operator(String username, String password, String name) {
		super.username = username;
		super.password = password;
		super.name = name;
		type = "O";
	}
}
