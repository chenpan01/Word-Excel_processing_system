package com.bjsxt.model;

import javax.mail.Authenticator;  
import javax.mail.PasswordAuthentication;  
  
public class MyAuthenticator extends Authenticator{  
    String name;  
    String password;  
      
    public MyAuthenticator(String name, String password){  
        this.name = name;  
        this.password = password;  
        getPasswordAuthentication();  
    }  
    protected PasswordAuthentication getPasswordAuthentication(){  
        return new PasswordAuthentication(name,password);  
    }  
}  

