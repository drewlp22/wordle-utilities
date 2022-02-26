import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class WordReducer {

    public static List<String> getWordList() throws IOException {
        File input = new File("5_letter_words.txt");
        List<String> output = new ArrayList<String>();

        if (input.exists()) {
            output = Files.readAllLines(input.toPath(), Charset.defaultCharset());
        }

        return output;
    }

    public static boolean checkWordForLetters(String input, String exclude, String include) {
        char[] exChar = exclude.toCharArray();
        char[] inChar = include.toCharArray();

        if (exclude != null) {
            for (char x : exChar) {
                if (input.contains(String.valueOf(x))) return false;
            }
        }
        if (include != null) {
            for (char y : inChar) {
                if (!input.contains(String.valueOf(y))) return false;
            }
        }
        return true;
    }

    public static List<String> returnValidWords(List<String> input, String exclude, String include) {
        List<String> validWords = new ArrayList<String>();

        for (String word : input) {
            if (checkWordForLetters(word, exclude, include))
                validWords.add(word);
        }

        return validWords;
    }

    public static void printRandomWords(List<String> input, int count){
        Random rng = new Random();
        int k;

        for (int i = 0; i < count; i++){
            k = rng.nextInt(input.size());
            System.out.println(input.get(k));
        }
    }

    public static void main(String[] args) {
        List<String> wordleWords;
        Scanner kb = new Scanner(System.in);
        String ygr, gre, ans;
        int numGuesses;
        boolean solved = false;

        try {
            wordleWords = getWordList();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (!solved) {
            System.out.println("Enter Yellow/Green characters: ");
            ygr = kb.nextLine();
            System.out.println("Enter Grey characters: ");
            gre = kb.nextLine();
            System.out.println("Number of guesses to print: ");
            numGuesses = kb.nextInt();

            wordleWords = returnValidWords(wordleWords, gre, ygr);
            printRandomWords(wordleWords, numGuesses);

        }
        kb.close();
    }
}