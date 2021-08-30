import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class decryption {

	public static String decrypt(String encryptedText, String aesKey, String salt, IvParameterSpec iv)
			throws Exception {
		String password = aesKey;
//	    SecureRandom random = new SecureRandom();
//	    byte bytes[] = new byte[20];
//	    random.nextBytes(bytes);
		byte[] saltBytes = salt.getBytes("UTF-8");

		// Derive the key
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 1000, 256);
		SecretKey secretKey = factory.generateSecret(spec);
		SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secret, iv);
		byte decryptedTextBytes[] = null;
		try {
			decryptedTextBytes = cipher.doFinal(new Base64().decode(encryptedText));
		} catch (IllegalBlockSizeException e) {
			// log.debug(e.getMessage());
		} catch (BadPaddingException e) {
			// log.debug(e.getMessage());
		}
		String value = new String(decryptedTextBytes);
		return value;
	}

	public static String encrypt(String word, String aesKey, String salt, IvParameterSpec iv) throws Exception {
		// byte[] ivBytes;
		String password = aesKey;
//		    SecureRandom random = new SecureRandom();
//		    byte bytes[] = new byte[20];
//		    random.nextBytes(bytes);
		byte[] saltBytes = salt.getBytes("UTF-8");

		// Derive the key
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 1000, 256);
		SecretKey secretKey = factory.generateSecret(spec);
		SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
		// encrypting the word
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, secret, iv);
		byte[] encryptedTextBytes = cipher.doFinal(word.getBytes("UTF-8"));

		return new Base64().encodeToString(encryptedTextBytes);
	}

	public static void main(String[] args) throws Exception {

//		List<String> inputList = new ArrayList<String>();
//		try {
//			File inputF = new File("/home/ameer.khan@ameexusa.net/Downloads/patient_protocol.activity_type.csv");
//			InputStream inputFS = new FileInputStream(inputF);
//			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
//			// skip the header of the csv
//			inputList = br.lines().skip(1).collect(Collectors.toList());
//			br.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		String[] inputList = { "Y2FyZXZpc29yQDEyM+mFhQImV8NaT9eIL9FX9vw=", "Y2FyZXZpc29yQDEyMzFbQTZGP5dVrIgBeVkyNTI=" };
//		for (String string : inputList) {
//
//			System.out.println(decrypt(string, "carevisor@npc", "carevisor@123"));
//		}
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		String cipherText = encrypt("Covid Best Practices", "carevisor@npc", "carevisor@123", ivSpec);
		System.out.println(cipherText);
		String plainText = decrypt(cipherText, "carevisor@npc", "carevisor@123", ivSpec);
		System.out.println(plainText);

	}
}
