package br.com.fintech.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Cryptographer {
	
	private final String encryptedPassword;
	private final String salt;
	
	private Cryptographer(String encryptedPassword, String salt) {
		this.encryptedPassword = encryptedPassword;
		this.salt = salt;
	}
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	
	public String getSalt() {
		return salt;

	}
	
	public static String cryptographMD5 (String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		md.update(password.getBytes("ISO-8859-1"));
		
		BigInteger hash = new BigInteger(1, md.digest());
		
		return hash.toString(16);
	}
	
	public static String getRandomSalt (int len) {
		String range = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~^?!@#$%&*";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		
		for(int i = 0; i < len; i++) {
			sb.append(range.charAt(random.nextInt(range.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomSalt () {
		int len = 12;
		String range = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~^?!@#$%&*";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		
		for(int i = 0; i < len; i++) {
			sb.append(range.charAt(random.nextInt(range.length())));
		}
		return sb.toString();
	}
	
	public static Cryptographer cryptographWithSalt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String salt = getRandomSalt();
		String unencryptedPassword = password.concat(salt);
		String encryptedPassword = Cryptographer.cryptographMD5(unencryptedPassword);
		
		return new Cryptographer(encryptedPassword, salt);
	}
	
	public static Cryptographer cryptographWithSalt(String password, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String unencryptedPassword = password.concat(salt);
		String encryptedPassword = Cryptographer.cryptographMD5(unencryptedPassword);
		
		return new Cryptographer(encryptedPassword, salt);
	}
}
