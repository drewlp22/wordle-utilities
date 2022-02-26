import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class WordParse {

    public static void main(String[] args) throws IOException {
        File input = new File("src/words_alpha.txt");
        FileWriter output = new FileWriter("5_letter_words.txt");

        System.out.println("Opened File");
        List<String> allWords = new ArrayList<String>();

        if (input.exists()){
            System.out.println();
            try{
                allWords = Files.readAllLines(input.toPath(), Charset.defaultCharset());
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("File does not exist");
        }
        for (String word : allWords){
            if(word.length() == 5) {
                output.write(word + "\n");
            }
        }
        input = new File("src/words_alpha2.txt");
        if (input.exists()){
            System.out.println();
            try{
                allWords = Files.readAllLines(input.toPath(), Charset.defaultCharset());
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("File does not exist");
        }
        for (String word : allWords){
            if(word.length() == 5) {
                output.write(word + "\n");
            }
        }

        output.close();
    }
}
