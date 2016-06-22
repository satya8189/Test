
package com.wre.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * @author 
 * @since 22-05-2015
 * @version 1.0
 * Contains the utility methods(password encryption login) of Applications
 * in this class
 */

public class WREUtil {

	private static final Log log = LogFactory.getLog(WREUtil.class);

	private static byte[] sharedvector = {
	    0x01, 0x02, 0x03, 0x05, 0x07, 0x0B, 0x0D, 0x11
	    };
	
	
	public  static String EncryptText(String RawText)
    {
        String EncText = "";
        byte[] keyArray = new byte[24];
        byte[] temporaryKey;
        String key = "developersnotedotcom";
        byte[] toEncryptArray = null;
  
        try
        {
 
            toEncryptArray =  RawText.getBytes("UTF-8");        
            MessageDigest m = MessageDigest.getInstance("MD5");
            temporaryKey = m.digest(key.getBytes("UTF-8"));
 
            if(temporaryKey.length < 24) // DESede require 24 byte length key
            {
                int index = 0;
                for(int i=temporaryKey.length;i< 24;i++)
                {                   
                    keyArray[i] =  temporaryKey[index];
                }
            }        
 
            Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");            
            c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));            
            byte[] encrypted = c.doFinal(toEncryptArray);            
            EncText = Base64.encodeBase64String(encrypted);
 
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
 
        return EncText;        
    }
	
	
	public  static String DecryptText(String EncText)
    {
 
        String RawText = "";
        byte[] keyArray = new byte[24];
        byte[] temporaryKey;
        String key = "developersnotedotcom";
        byte[] toEncryptArray = null;
 
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            temporaryKey = m.digest(key.getBytes("UTF-8"));           
 
            if(temporaryKey.length < 24) // DESede require 24 byte length key
            {
                int index = 0;
                for(int i=temporaryKey.length;i< 24;i++)
                {                  
                    keyArray[i] =  temporaryKey[index];
                }
            }
            
            Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
            byte[] decrypted = c.doFinal(Base64.decodeBase64(EncText));   
 
            RawText = new String(decrypted, "UTF-8");                    
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }  
 
        return RawText; 
 
    }
 
    
 

	
	
	
	
	
		private static String byteArray2Hex(byte[] hash){
		log.info("Inside a byteArray2Hex method");

		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		return formatter.toString();
	}

	/**
	 * Encrypt data
	 * @return String
	 * @param MessageDigest,String
	 * @throws
	 */
	private static String calculateHash(MessageDigest algorithm,String message) {
		log.info("Inside a calculateHash method");

		algorithm.update(message.getBytes());
		byte[] hash = algorithm.digest();
		return byteArray2Hex(hash);
	}

	/**
	 * It encrypt the data.
	 * @return String
	 * @param String
	 * @throws 
	 */
	/*public static String encryptData(String pwd){
		log.info("Inside a encryptData method");

		String encrypted = "";
		try{
			MessageDigest messageDigestObj  = MessageDigest.getInstance("MD5");
			encrypted = calculateHash(messageDigestObj, pwd);
		}catch(Exception e){
			log.error("Error while encrypt the password >>>>> "+e.getMessage());
		}
		return encrypted;
	}*/

public static HttpSession getSession() {
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    return attr.getRequest().getSession(true); // true == allow create
}


public static String encryptData(String RawText) {
String EncText = "";
byte[] keyArray = new byte[24];
byte[] temporaryKey;
String key = "developersnotedotcom";
byte[] toEncryptArray = null;
try {
	toEncryptArray = RawText.getBytes("UTF-8");
	MessageDigest m = MessageDigest.getInstance("MD5");
	temporaryKey = m.digest(key.getBytes("UTF-8"));

	if (temporaryKey.length < 24) // DESede require 24 byte length key
	{
		int index = 0;
		for (int i = temporaryKey.length; i < 24; i++) {
			keyArray[i] = temporaryKey[index];
		}
	}
	Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
	c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyArray, "DESede"),
			new IvParameterSpec(sharedvector));
	byte[] encrypted = c.doFinal(toEncryptArray);
	EncText = Base64.encodeBase64String(encrypted);
} catch (Exception NoEx) {
	JOptionPane.showMessageDialog(null, NoEx);
}
return EncText;
}

public static String decrypt(String EncText) {

String RawText = "";
byte[] keyArray = new byte[24];
byte[] temporaryKey;
String key = "developersnotedotcom";
try {
	MessageDigest m = MessageDigest.getInstance("MD5");
	temporaryKey = m.digest(key.getBytes("UTF-8"));

	if (temporaryKey.length < 24) { // DESede require 24 byte length key
		int index = 0;
		for (int i = temporaryKey.length; i < 24; i++) {
			keyArray[i] = temporaryKey[index];
		}
	}
	Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
	c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyArray, "DESede"),
			new IvParameterSpec(sharedvector));
	byte[] decrypted = c.doFinal(Base64.decodeBase64(EncText));
	RawText = new String(decrypted, "UTF-8");
} catch (Exception NoEx) {
	JOptionPane.showMessageDialog(null, NoEx);
}
return RawText;
}

public static String generateRandomCode() {

log.info("Entered into generateRandomCode() method..");
String chars = "abcdefghijklmnopqrstuvwxyz"
		+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
final int PW_LENGTH = 6;
Random rnd = new SecureRandom();
StringBuilder pass = new StringBuilder();
for (int i = 0; i < PW_LENGTH; i++) {
	pass.append(chars.charAt(rnd.nextInt(chars.length())));
}
return pass.toString();
}


	/**
	   * This method makes a "deep clone" of any object it is given.
	   */
	  public static Object deepClone(Object object) {
	    try {
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ObjectOutputStream oos = new ObjectOutputStream(baos);
	      oos.writeObject(object);
	      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	      ObjectInputStream ois = new ObjectInputStream(bais);
	      return ois.readObject();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	  }


	  public static void deleteFolder(String folderToDelete) throws IOException {
	        String os = System.getProperty("os.name").toLowerCase();
	        File emptyFolder = createEmptyDirectory();
	        if (isWindows(os)) {
	                Runtime.getRuntime().exec("cmd /c robocopy " + emptyFolder + " " + folderToDelete + " /purge & rmdir " + folderToDelete);
	        } else if (isUnix(os) || isMac(os) || isSolaris(os)) {
	                Runtime.getRuntime().exec("rm -r -f  " + folderToDelete);
	        }
	}
	private static File createEmptyDirectory() {
	        File emptyFolder = new File("EmptyFolder");
	        if (!emptyFolder.exists()) {
	                boolean isCreated = emptyFolder.mkdir();
	        }

	        return emptyFolder;
	}

	public static boolean isWindows(String os) {
	        return os.contains("win");
	}

	public static boolean isUnix(String os) {
	        return os.contains("nix") || os.contains("aix") || os.contains("nux");
	}

	public static boolean isSolaris(String os) {
	        return os.contains("sunos");
	}

	public static boolean isMac(String os) {
	        return os.contains("mac");
	}
	  
	  
}



