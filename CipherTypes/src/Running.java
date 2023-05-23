import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.spec.InvalidKeySpecException;


public class Running {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a cipher to use:");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Vigenere Cipher");
        System.out.println("3. Playfair Cipher");
        System.out.println("4. DES Cipher");
        System.out.println("5. AES Cipher");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter the message:");
            Scanner scanner1 = new Scanner(System.in);
            String message = scanner1.nextLine().toUpperCase();
            System.out.println("Enter the shift amount:");
            int shift = scanner1.nextInt();
            String encryptedMessage = CaesarCipher.encryptData(message, shift);
            String decryptedMessage = CaesarCipher.decryptData(CaesarCipher.encryptData(message, shift), shift);
            System.out.println("Encrypted Message: " + encryptedMessage);
            System.out.println("Decrypted Message: " + decryptedMessage);
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Key:");
            String key = sc.nextLine();
            System.out.println("Enter Message");
            String message = sc.nextLine();
            String encryptedMsg = VigenerCipher.encrypt(message, key);
            System.out.println("Message: " + message);
            System.out.println("Encrypted message: " + encryptedMsg);
            System.out.println("Decrypted message: " + VigenerCipher.decrypt(encryptedMsg, key));
        } else if (choice == 3) {
            PlayFairCipher x = new PlayFairCipher();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a keyword:");
            String keyword = sc.next();
            x.setKey(keyword);
            x.KeyGen();
            System.out.println("Enter word to encrypt: \"Make sure length of message is even\"");
            String key_input = sc.next();
            if (key_input.length() % 2 == 0) {
                System.out.println("Encryption: " + x.encryptMessage(key_input));
                System.out.println("Decryption: " + x.decryptMessage(x.encryptMessage(key_input)));
            } else {
                System.out.println("Message length should be even");
            }
        } else if (choice == 4) {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Text:");
            String st = s.nextLine();

            byte[] text = st.getBytes();
            System.out.println("Text [Byte Format] : " + text);
            System.out.println("Text : " + new String(text));

            byte[] textEncrypted = desCipher.doFinal(text);

            System.out.println("Text Encryted : " + textEncrypted);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            System.out.println("Text Decryted : " + new String(textDecrypted));

        } else if (choice == 5) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter Original String: ");
            String originalString = sc2.nextLine();

            // Call encryption method
            String encryptedString = AES.encrypt(originalString);

            // Call decryption method
            String decryptedString = AES.decrypt(encryptedString);

            // Print all strings
            System.out.println("Original String: " + originalString);
            System.out.println("Encrypted String: " + encryptedString);
            System.out.println("Decrypted String: " + decryptedString);
        }


        else {
            System.out.println("Invalid Cipher Type !!");
        }


    }

}
