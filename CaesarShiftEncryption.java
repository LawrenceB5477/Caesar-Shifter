/**
 * Generates an encrypted message and alphabet based on a caesar shift key 
 * @author Lars Beutlich
 * @version 3/21/2017
 */
public class CaesarShiftEncryption
{
    private static String[] alphabet = CaesarShiftTester.genAlphabet(CaesarShiftTester.ALPHABET);
    
    //Generates a encrypted alphabet based on an inputed key 
    public static String[] genEncryptAlphabet(int key)
    {
        String[] encryptAlph = new String[26]; 
        for(int i = 0; i < 26; i++)
        {
            if( i + key >= 0 && i + key <= 25)
            {
                encryptAlph[i] = alphabet[i + key]; 
            } else if ( i + key > 25)
            {
                encryptAlph[i] = alphabet[(i + key) - 26]; 
            }
        }
        return encryptAlph; 
    }
    
    //Creates an encrypted message 
    public static String getEncryption(String input, String[] encryptAlph)
    {
        String message = "";
        String character = ""; 
        int index = 0; 
        for (int i = 0; i < input.length(); i++)
        {
            //Gets the inputed message one character at a time 
            character = input.substring(i, i+1); 
            //Finds the corresponding position of the character in the alphabet 
            for(int j = 0; j < 26; j++)
            {
                if(character.equals(alphabet[j]))
                {
                    index = j;  
                }
            }
            character = encryptAlph[index];
            message += character; 
        }
        return message; 
    }
}
