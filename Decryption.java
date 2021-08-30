import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

enum Direction {

	EAST, WEST
}
class Decryption {

	static Logger logger = Logger.getLogger("Decryption");

	int a = 10;

	public static String decrypt(String strToDecrypt, String secret) {

		String value = null;
		try {
			byte[] key = Arrays.copyOf(secret.getBytes(), 32);
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			value = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public static String encrypt(String strToEncrypt, String secret) {

		String value = null;
		try {
			byte[] key = Arrays.copyOf(secret.getBytes(), 32);
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			value = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	class SampleThread extends Thread {
		public int processingCount = 0;

		SampleThread(int processingCount) {
			this.processingCount = processingCount;
			logger.info("Thread Created");
		}

		@Override
		public void run() {
			logger.info("Thread " + this.getName() + " started");
			while (processingCount > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.info("Thread " + this.getName() + " interrupted");
				}
				processingCount--;
			}
			logger.info("Thread " + this.getName() + " exiting");
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Decryption decryption = new Decryption();
		System.out.println(decryption.a);

		Direction east = Direction.EAST;
		Direction west = Direction.WEST;

		
		assert decryption.a < 9 : decryption.a;

//		Thread thread = new Thread(() -> {
//			// some dummy queue
//			TransferQueue<String> queue = new LinkedTransferQueue<>();
//			while (!Thread.currentThread().isInterrupted()) {
//				try {
//					logger.info(() -> "For 3 seconds the thread " + Thread.currentThread().getName()
//							+ " will try to poll an element from queue ...");
//					queue.poll(3000, TimeUnit.MILLISECONDS);
//				} catch (InterruptedException ex) {
//					logger.severe(() -> "InterruptedException! The thread " + Thread.currentThread().getName()
//							+ " was interrupted!");
//					Thread.currentThread().interrupt();
//				}
//			}
//			logger.info(() -> "The execution was stopped!");
//		});
//
//		thread.start();
//		Thread.sleep(1500);
//		thread.interrupt();
//		System.out.println(decrypt("oxcNkwFYJ2a0mlms85DHwXpLTUvj404QZo4G4c9wAgw=", "carevisor@npc"));
//		System.out.println(encrypt("CarevisorAnonymous", "carevisor@npc"));
	}
}
