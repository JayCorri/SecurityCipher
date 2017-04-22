
public class SecurityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecurityCipher tester = new SecurityCipher();
		String cipherMessage = tester.EncryptionCipher();
		System.out.println("User Defined Cipher\norigMessage: " + tester.getOrigMessage());
		System.out.println("EncryptionCipher returns: " + cipherMessage);
		String decryptedMessage = tester.DecryptionCipher();
		System.out.println("DecryptionCipher returns: " + decryptedMessage);
		String origMessage = tester.getOrigMessage();
		boolean passFail = tester.Compare(origMessage, decryptedMessage);
		System.out.println("Compare returns: " + passFail);
		
		SecurityCipher cipher2 = new SecurityCipher("ThisIsAnATBASHEncryptionHandlingOnlyTheAlphabet", 1);
		String encryption2 = cipher2.EncryptionCipher(1);
		String decryption2 = cipher2.DecryptionCipher(1);
		System.out.println("\nATBASH encryption:");
		System.out.println("origMessage: " + cipher2.getOrigMessage());
		System.out.println("EncryptionCipher returns: " + encryption2);
		System.out.println("DecryptionCipher returns: " + decryption2);
		System.out.println("Compare returns: " + cipher2.Compare(cipher2.getOrigMessage(), decryption2));
		

	}

}
