package com.cy.demo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
       
    public static String md5Num(String str) {

    	System.out.println(str);
        byte [] data = str.getBytes();    	
    	try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");		       
			
			md5.update(data);			 			 	     	     
			
			String  data1  =new BigInteger(1, md5.digest()).toString(16);			
			
			System.out.println(data1);
			
			return data1;
			
    	} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return null;
	
	}
}
