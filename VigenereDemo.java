package vigenerecipher;
import java.util.Scanner;

public class VigenereDemo {

    private int ascmov = (int)'a'; // сдвиг по ASCII

    public static void main(String args[]){
        VigenereDemo vd = new VigenereDemo();

        Scanner scr = new Scanner(System.in);

        System.out.println("Enter text: ");
        String encodingText = scr.nextLine();

        System.out.println("Enter key: ");
        String key = scr.nextLine();
        String encodedText = vd.encrypt(encodingText, key);
        System.out.println(encodedText);

        System.out.println("Enter decoded text: ");
        String decodingText = scr.nextLine();
        String decodedText = vd.decrypt(decodingText,key);
        System.out.println(decodedText);
    }


    private String encrypt(String text, String keyWord){
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int num = ((text.charAt(i) + keyWord.charAt(i % keyWord.length()) - 2 * ascmov) % 26);
            char c = (char)(num + ascmov);
            ans.append(c);
        }

        return ans.toString();
    }

    private String decrypt(String cipher, String keyWord) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            int num = ((cipher.charAt(i) - keyWord.charAt(i % keyWord.length()) + 26) % 26);
            char c = (char)(num + ascmov);
            ans.append(c);
        }

        return ans.toString();
    }
}
