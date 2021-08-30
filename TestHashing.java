import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestHashing {

	public static String getHashedValue(final String passwordToHash, final String salt) {

		String hashedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder password = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				password.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hashedPassword = password.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashedPassword;

	}
	
	public static void main(String[] args) {
		
		String email = "memberas@mailinator.com";
		String salt = "carevisor@123";
		System.out.println(getHashedValue(email, salt));
	}
}
