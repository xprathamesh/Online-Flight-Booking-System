package com.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Shamli Singh
 *
 */

public class HashPassword {
	
	public static final String SALT = "kingfly-airlines-salt-text";
	
	public static String generateHash(String password) {
		StringBuilder hashedPassword = new StringBuilder();
		
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = sha.digest((password+SALT).getBytes()); //hash computation
			char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hashedPassword.append(hexDigits[(b & 0xf0) >> 4]); //f0 = 0000 0000 1111 0000
				hashedPassword.append(hexDigits[b & 0x0f]); //0f = 0000 0000 0000 1111
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashedPassword.toString();
	}
}
