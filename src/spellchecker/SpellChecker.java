//Ryan Draper, TTh 4-5pm
package spellchecker;

import java.io.IOException;
import java.util.*;

public class SpellChecker {

    public static void main(String[] args) throws IOException {
        Checker c = new Checker();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a word:");
        String enteredWord = s.nextLine();
        if (c.getDictionary().contains(enteredWord)) {
            System.out.println("No Mistakes Found");
        } else {
            System.out.println("Suggestion: " + c.suggest(enteredWord));
        }
    }
}

/* 
SAMPLE OUTPUT:

Enter a word:
rea
Suggestion: area

Enter a word:
boo
Suggestion: book

Enter a word:
abusiness
Suggestion: business

Enter a word:
caseb
Suggestion: case

Enter a word:
hcild
Suggestion: child

Enter a word:
cmopany
Suggestion: company

Enter a word:
conutry
Suggestion: country

 */
