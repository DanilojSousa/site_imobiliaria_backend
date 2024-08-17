package br.com.tecnologia.sistema.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Util {
	
	   private static final String SECRET_KEY = "BR_COM_CONTROLES";
	
	//encriptar
	   public static String encrypt(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            byte[] hash = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hash) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Erro ao criptografar senha", e);
	        }
	    }
	    
	    public static String encode(String text, Long time) throws Exception {
	    	Long currentTimeMillis = System.currentTimeMillis();
	    	Long expirationTimeMillis = currentTimeMillis + time;
	    	String formattedTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(expirationTimeMillis));
	    	String token = text +"_"+formattedTime;
	    	SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
	    	Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    	cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	    	byte[] encryptedBytes = cipher.doFinal(token.getBytes("UTF-8"));
	    	String base64 = Base64.getEncoder().encodeToString(encryptedBytes);
	    	return base64;
	    }

	    public static String decode(String encodedText) throws Exception {
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
	        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
	        String decryptedTextWithTime = new String(decryptedBytes, "UTF-8");
	        String[] parts = decryptedTextWithTime.toString().split("_");
	        if (parts.length != 2) {
	            throw new Exception("Texto inválido");
	        }
	        String formattedTime = parts[1];
	        String decryptedText = parts[0];
	        Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(formattedTime);
	        long timeInMillis = date.getTime();
	        long currentTimeInMillis = System.currentTimeMillis();
	        if (currentTimeInMillis - timeInMillis > timeInMillis) {
	            throw new Exception("Texto expirado");
	        }
	        return decryptedText;
	    }
	    
	    public static String encodeBase64(byte[] bytes) {
	        return Base64.getEncoder().encodeToString(bytes);
	    }
	    
	    public static byte[] decodeBase64(String base64String) {
	        return Base64.getDecoder().decode(base64String);
	    } 
}
