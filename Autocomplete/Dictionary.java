import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/** 
 * Represents a Dictionary of all the words in
 * dictionary.txt 
 *
 * Dependencies: TrieNode.java, Trie.java, dictionary.txt
 *
 * Compilation/Run Instructions
 *  1. javac *.java
 *  2. java Dictionary be to li
 *
 *  (prints all words that start with 'be', 'to', and 'li')
 * */

public final class Dictionary { 
    
    private final Trie wordTrie;
    
    public Dictionary() { 
        this.wordTrie = new Trie();

        final String fileName = "dictionary.txt";
        final long startTime = System.currentTimeMillis();

        try { 
            final BufferedReader theReader = new BufferedReader(new FileReader(fileName));

            while(theReader.ready()) { 
                this.wordTrie.addWord(theReader.readLine());
            }

            System.out.println("Dictionary loaded in: " + (System.currentTimeMillis() - startTime));
        }

        catch(Exception e) { 
            System.out.println(e.toString());
        }
    }

    public Trie getTrie() { 
        return this.wordTrie;
    }

    public String[] getWords(final String prefix) { 
        final long startTime = System.currentTimeMillis();
        final String[] result = this.wordTrie.getWordsWithPrefix(prefix.toLowerCase());
        System.out.println(prefix + "\tResults: " + result.length + "\tIn MS: " + (System.currentTimeMillis() - startTime));
        return result;
    }

    public static void main(String[] ryan) { 
        final Dictionary dict = new Dictionary();

        for(String word : ryan) { 
            final String[] beWords = dict.getWords(word);
            
            for(String toBe : beWords) { 
                System.out.print(toBe + "    ");
            }
            System.out.println("\n\n");
        }
    }
}
