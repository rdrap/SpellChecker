//Ryan Draper, TTh 4-5pm
package spellchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Checker {

    private Hashtable<String, String> words;

    public Checker() {
        words = new Hashtable<String, String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/Ryan/Desktop/words.txt"));
            while (br.ready()) {
                String dictInput = br.readLine();
                String[] dict = dictInput.split("\\s");
                for (int i = 0; i < dict.length; i++) {
                    // key and value are set as the same
                    words.put(dict[i], dict[i]);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException Occured!");
        }
    }

    public String suggest(String enteredWord) throws IOException {
        for (String word : words.keySet()) {
            if (word.substring(1).equalsIgnoreCase(enteredWord)) {
                // if add one character to beginning
                return word;
            } else if (word.substring(0, word.length() - 1).equalsIgnoreCase(enteredWord)) {
                // if add one character to the end
                return word;
            } else if (word.equalsIgnoreCase(enteredWord.substring(1))) {
                // if remove one character from the beginning
                return word;
            } else if (word.equalsIgnoreCase(enteredWord.substring(0, enteredWord.length() - 1))) {
                // if remove one character from the end
                return word;
            } else {
                // if exchange adjacent characters
                for (int i = 0; i < enteredWord.length() - 1; i++) { 
                    char letters[] = enteredWord.toCharArray();
                    char temp = letters[i];
                    letters[i] = letters[i + 1];
                    letters[i + 1] = temp;
                    String newWord = new String(letters);
                    if (newWord.equalsIgnoreCase(word)) {
                        return word;
                    }
                }
            }
        }
        return "No Word Found";
    }

    public Hashtable<String, String> getDictionary() {
        return words;
    }
}
