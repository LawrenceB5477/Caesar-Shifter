/**
 * Creates a console to encrypt and decrypt caeser shifted messages
 * @author Lars Beutlich
 * @version 3/21/2016
 */
import java.util.Scanner; 
public class CaesarShiftTester
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; 
    
    //Static method to generate an array from the alphabet constant
    public static String[] genAlphabet(String alphabet)
    {
        String[] alphabetArray = new String[26]; 
        for(int i = 0; i < 26; i++)
        {
            alphabetArray[i] = ALPHABET.substring(i, i+1); 
        }
        return alphabetArray;
    }
    
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); 
        boolean end = false; 
        String input = ""; 
        //Menu, keeps going until user presses 3 
        System.out.println("Welcome to the Caeser shifter.");
        while(end == false)
        {
            System.out.println("1: Enter a message the encrypt and a key. (E)"); 
            System.out.println("2: Enter a message to decrypt and a key. (D)"); 
            System.out.println("3: Enter 3 to quit. (Q)"); 
            System.out.print("Enter a selection: "); 
            input = in.nextLine(); 
            System.out.println(); 
            
            //Performs the requested actions 
            if(input.equalsIgnoreCase("E"))
            {
                System.out.println("Enter in the phrase you would like to encrypt:"); 
                String phrase = in.nextLine(); 
                System.out.println("Enter in the encryption key you would like to use, as an integer (0-25):"); 
                int key = in.nextInt(); 

                //Generates the encrypted alphabet and prints it 
                System.out.println(); 
                System.out.println("Your new alphabet is: ");
                String[] encryptedAlphabet = CaesarShiftEncryption.genEncryptAlphabet(key); 
                for ( String chara : encryptedAlphabet)
                {
                    System.out.print(chara); 
                }
                System.out.println(); 
                
                //Generates a code based on the encrypted alphabet and e=prints it 
                System.out.println("Your code is: "); 
                String message = CaesarShiftEncryption.getEncryption(phrase, encryptedAlphabet); 
                System.out.println(message); 
                System.out.println(); 
            } else if (input.equalsIgnoreCase("D"))
            {
                System.out.println("Enter in the phrase you would like to decrypt:"); 
                String phrase = in.nextLine(); 
                System.out.println("Enter in the encryption key you would like to use, as an integer (0-25):"); 
                final int KEY = in.nextInt(); 
                
                //Generates the encrypted alphabet and prints it 
                System.out.println(); 
                System.out.println("Your new alphabet is: ");
                String[] encryptAlphabet = CaesarShiftDecryption.genEncryptAlphabet(KEY); 
                for ( String chara : encryptAlphabet)
                {
                    System.out.print(chara); 
                }
                System.out.println(); 

                //Decrypts the message entered based on the shift key 
                System.out.println("Your decrypted code is: ");
                String message = CaesarShiftDecryption.getDecryption(phrase, encryptAlphabet); 
                System.out.println(message);
                System.out.println(); 
            } else if (input.equalsIgnoreCase("Q"))
            {
                System.out.println("Thank you, exiting."); 
                end = true; 
            } else 
            {
                System.out.println("I did not understand, please try again."); 
            }
            
        }
        
    }
}
