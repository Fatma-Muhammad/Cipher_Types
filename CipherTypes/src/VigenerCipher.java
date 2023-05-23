import java.util.Scanner;

public class VigenerCipher {
    public static String encrypt(String Plaintext, final String key) {
        String res = "";
        Plaintext = Plaintext.toUpperCase();
        for (int i = 0, j = 0; i < Plaintext.length(); i++) {
            char c = Plaintext.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public static String decrypt(String Ciphertext, final String key) {
        String res = "";
        Ciphertext = Ciphertext.toUpperCase();
        for (int i = 0, j = 0; i < Ciphertext.length(); i++) {
            char c = Ciphertext.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

}