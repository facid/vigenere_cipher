package vigenerecipher;
import java.util.Scanner;

public class VigenereDemo {

    private int asciiMove = (int)'a';

    public static void main(String args[]){
        VigenereDemo vd = new VigenereDemo();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text: ");
            String encodingText = scanner.nextLine();

            System.out.println("Enter key: ");
            String key = scanner.nextLine();
            String encodedText = vd.encrypt(encodingText, key);
            System.out.println(encodedText);

            System.out.println("Enter decoded text: ");
            String decodingText = scanner.nextLine();
            String decodedText = vd.decrypt(decodingText, key);
            System.out.println(decodedText);
        }
    }

    private String encrypt(String text, String keyWord) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int num = ((text.charAt(i) + keyWord.charAt(i % keyWord.length()) - 2 * asciiMove) % 26);
            char newLetter = (char)(num + asciiMove);
            builder.append(newLetter);
        }

        return builder.toString();
    }

    private String decrypt(String cipher, String keyWord) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            int num = ((cipher.charAt(i) - keyWord.charAt(i % keyWord.length()) + 26) % 26);
            char letter = (char)(num + asciiMove);
            builder.append(letter);
        }

        return builder.toString();
    }
}
