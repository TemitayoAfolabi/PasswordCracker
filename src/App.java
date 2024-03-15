import java.util.Scanner;

public final class App {

    private static final String wordListFilePath = "/Users/temitayo_afolabi/downloads/realuniq.lst";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password: ");

        // Mask the password input
        char[] passwordChars = System.console().readPassword();
        
        String password = new String(passwordChars);

        String hashPlaceholder = MD5Hashing.md5(password);
        WordListCracker.crackPasswordWithWordList(hashPlaceholder, wordListFilePath);

        // Clear the password from memory
        java.util.Arrays.fill(passwordChars, ' ');

        scanner.close();
    }
}
