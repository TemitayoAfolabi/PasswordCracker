import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordListCracker extends MD5Hashing {

    public static void crackPasswordWithWordList(String targetHash, String wordListPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(wordListPath))) {
            String word;
            while ((word = br.readLine()) != null) {
                if (md5(word).equals(targetHash)) {
                    System.out.println("Password found: " + word);
                    return ;
                }
            }
            System.out.println("Password not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     String hashPlaceholder = md5("Afolabi97");
    //     crackPasswordWithWordList(hashPlaceholder, "/Users/temitayo_afolabi/downloads/realuniq.lst");
    // }
}
