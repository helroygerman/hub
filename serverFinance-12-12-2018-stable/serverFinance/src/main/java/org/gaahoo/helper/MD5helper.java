package org.gaahoo.helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5helper {

	public static String  hash(String txt){
		
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(txt.getBytes(StandardCharsets.UTF_8));

	        
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public boolean exact(String password,String txt){
		
		return password.equals(txt);
	}
	
}
