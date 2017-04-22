/*
 ****************************************************************************
 * 																			*
 * CISC 190 - 04/22/2017													*
 * Assignment 5 Alternative													*
 * Douglas Corrigan - April 22, 2017										*
 * 																			*
 * 																			*
 * Brief Description:														*
 * This program performs an encryption and decryption for two Ciphers a		*
 * user defined cipher and the ATBASH cipher.  Additionally a Print(String)	*
 * method will println the String it is passed and a Compare(String, String)*
 * method will return boolean true/false if the two Strings are equal or	*
 * not.																		*
 * 																			*
 * Special Classes:															*
 * None																		*
 * 																			*
 * 																			*
 * Detailed Notes on Code:													*
 * The user defined cipher changes the character by an increment of 1 		*
 * according to the ASCII code.  The ATBASH cipher maps each character		*
 * according to the ATBASH mapping function.  This ATBASH cipher can account*
 * for lowercase and uppercase lettering but no special characters are		*
 * accounted for.  The default constructor is assigned to the user defined	*
 * cipher.  The user defined cipher is assign to the default constructor and*
 * the ATBASH cipher is assigned to the SecurityCipher(int) constructor.	*
 * 																			*
 * Field:																	*
 * The field consists of int diameter, String origMessage, String cipherMes-*
 * sage, String decryptedMessage, int key, boolean placeholder, char[][]	*
 * ATBASHLOWERCASE, and char[][] ATBASHUPPERCASE.  Special note should be	*
 * made that int key was never used for this class.							*
 * 																			*
 * Getters:																	*
 * Getters available are getDiameter() and getOrigMessage().				*
 * 																			*
 * Setters:																	*
 * Setters available are setDiameter(int) and setKey(int).					*
 * 																			*
 * 																			*
 ****************************************************************************
 */
public class SecurityCipher {

	//fields
	private int diameter;
	private String origMessage;
	private String cipherMessage;
	private String decryptedMessage;
	private int key;
	private boolean placeholder;
	private final char[][] ATBASHLOWERCASE = 
		{
				{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'},
				{'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n'}
		};
	private final char[][] ATBASHUPPERCASE = 
		{
				{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'},
				{'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N'}
		};
	//Constructors
	public SecurityCipher()
	{
		this.origMessage = "my name is Douglas Corrigan";
		this.cipherMessage = "";
		this.decryptedMessage = "";
	}
	public SecurityCipher(String origMessage, int diameter)
	{
		this.origMessage = origMessage;
		this.diameter = diameter;
		this.cipherMessage = "";
		this.decryptedMessage = "";
	}
	
	//User defined encryption
	public String EncryptionCipher()
	{
		//create the cipherMessage from origMessage
		for(int i = 0; i < origMessage.length(); i++)
		{
			//increment origMessage by one in ASCII code
			cipherMessage = cipherMessage + (char)(origMessage.charAt(i) + 1);
		}
		//return the encrypted message
		return cipherMessage;
	}

	//User defined decryption
	public String DecryptionCipher()
	{
		//create the decryptedMessage from cipherMessage
		for(int i = 0; i < cipherMessage.length(); i++)
		{
			//decrement the encrypted message by 1 in ASCII code
			decryptedMessage = decryptedMessage + (char)(cipherMessage.charAt(i) - 1);
		}
		//return the decrypted message
		return decryptedMessage;
	}
		
	//ATBASH encryption
	//A-Z 65-90; a-z 97-122
	public String EncryptionCipher(int diameter)//ATBASH
	{
		//char[][] atbash will be used to switch between ATBASHLOWERCASE and ATBASHUPPERCASE
		char[][] atbash = new char[2][13];
		//a for loop is initiated to map each character
		for(int i = 0; i < origMessage.length(); i++)
		{
			int currentCharAscii = (int)origMessage.charAt(i);
			//A-Z
			// an if-else loop statement is initiated to differentiate between upper and lower case
			if(currentCharAscii > 64 & currentCharAscii < 91)
				atbash = ATBASHUPPERCASE;
			//a-z
			else
				atbash = ATBASHLOWERCASE;
			// a nested for loop maps the character according to atbash
			for(int row = 0; row < atbash.length; row++)
			{
				for(int col = 0; col < atbash[row].length; col++)
				{
					//nested if statement to determine if the character and mapping match
					if(origMessage.charAt(i) == atbash[row][col])
					{
						//nested if-else statement correctly encrypts the character
						if(row == 0)
							cipherMessage = cipherMessage + atbash[row + 1][col];
						else
							cipherMessage = cipherMessage + atbash[row - 1][col];
					}
				}
			}
		}
		return cipherMessage;
	}
	
	//ATBASH decryption
	public String DecryptionCipher(int diameter)//ATBASH
	{
		// The EncryptionCipher is repeated to decode the message
		char[][] atbash = new char[2][13];
		for(int i = 0; i < cipherMessage.length(); i++)
		{
			int currentCharAscii = (int)cipherMessage.charAt(i);
			//A-Z
			if(currentCharAscii > 64 & currentCharAscii < 91)
				atbash = ATBASHUPPERCASE;
			//a-z
			else
				atbash = ATBASHLOWERCASE;
			for(int row = 0; row < atbash.length; row++)
			{
				for(int col = 0; col < atbash[row].length; col++)
				{
					if(cipherMessage.charAt(i) == atbash[row][col])
					{
						if(row == 0)
							decryptedMessage = decryptedMessage + atbash[row + 1][col];
						if(row == 1)
							decryptedMessage = decryptedMessage + atbash[row - 1][col];
					}
				}
			}
		}
		return decryptedMessage;
	}
	
	//General Methods
	public boolean Compare(String origMessage, String decryptedMessage)
	{
		if(origMessage.equals(decryptedMessage))
			placeholder = true;
		else
			placeholder = false;
		return placeholder;
	}
	
	public void Print(String printMessage)
	{
		System.out.println(printMessage);
	}
	
	//Getters
	public int getDiameter()
	{
		return diameter;
	}
	public String getOrigMessage()
	{
		return origMessage;
	}
	
	//setters
	public void setDiameter(int diameter)
	{
		this.diameter = diameter;
	}
	public  void setKey(int key)
	{
		this.key = key;
	}

}