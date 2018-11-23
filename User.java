/*
 * ENSF480
 * Term Project
 * Authors: Sean Mai 10154016
 *          Wafa Anam
 *          Karla Hernandez
 * Nov 14, 2018
 *
 */

import java.io.*;
import java.util.*;

public abstract class User{
    private String username;
    private String password;
    private String name;

    private boolean login(String username, String password){
        return(username.equals(this.username) && password.equals(this.username));
    }
}
