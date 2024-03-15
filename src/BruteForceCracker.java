import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BruteForceCracker {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void generate(StringBuilder current, int length, String targetHash) {
        if (current.length() == length) {
            String hash = hash(current.toString());
            if (hash.equals(targetHash)) {
                System.out.println("Password found: " + current);
                System.exit(0);
            }
            return;
        }

        for (char c : CHARACTERS.toCharArray()) {
            current.append(c);
            generate(current, length, targetHash);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        String targetHash = "7a95bf926a0333f57705aeac07a362a2"; // Example hash
        int maxLength = 4; // Example length
        generate(new StringBuilder(), maxLength, targetHash);
    }

     public static String hash(String password) {
         return password ;
     }
        
}
