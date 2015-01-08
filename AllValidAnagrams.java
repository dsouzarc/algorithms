import java.util.Hashtable;
import java.util.Arrays;
import java.util.LinkedList;

public class AllValidAnagrams { 

    public static Hashtable<String, LinkedList<String>> getSortedHashSet() { 

        //Get all the words
        final String[] allWords = Dictionary.getAllWordsArray();

        //For holding all the sorted words
        final Hashtable<String, LinkedList<String>> allVals = new Hashtable<String, LinkedList<String>>();

        //Add the sorted version of each word to the hashtable
        for(String word : allWords) { 

            //The word with the letters sorted alphabetically
            final String sorted = sortedWord(word);
            
            //All legit English words whose sorted characters are the same
            LinkedList<String> words = allVals.get(sorted);

            //If there are no words
            if(words == null) { 
                //Make a new list and add it to the map
                words = new LinkedList<String>();
                allVals.put(sorted, words);
            }

            //Add the word to the list
            words.add(word);
        }

        return allVals;
    }

    public static String sortedWord(final String word) { 
        final char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters).toLowerCase();
    }

    public static void main(String[] ryan) { 

        //Get a Hashtable where each key is a word where its letters are alphabetically sorted
        final Hashtable<String, LinkedList<String>> sortedWords = getSortedHashSet();


        //For each of the inputted words, print out all valid anagrams
        for(String r : ryan) { 
            final LinkedList<String> anagrams = sortedWords.get(sortedWord(r));

            //Some words have no anagrams
            if(anagrams == null || anagrams.size() == 0) { 
                System.out.println(r + "\tNo valid anagrams");
            }
            else { 
                System.out.println(r + "\t" + Arrays.toString(anagrams.toArray(new String[anagrams.size()])));
            }
        }
    }
}

