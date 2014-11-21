import java.util.LinkedList;
/** 
 * Written by Ryan D'souza
 * Represents a Trie, a data structure composed of
 * TrieNodes. Will be used for storing words */

public class Trie { 
    private final TrieNode root;

    public Trie() { 
        this.root = new TrieNode();
    }

    public void addWord(final String word) { 
        this.root.addWord(word.toLowerCase());
    }

    public LinkedList getWordsWithPrefix(final String prefix) { 
        TrieNode valNodes = root;

        for(Character c : prefix.toCharArray()) { 
            valNodes = valNodes.getNode(c);

            if(valNodes == null) {
                return new LinkedList();
            }
        }
        return valNodes.getWords();
    }

    public static void main(String[] ryan) { 
        Trie me = new Trie();
        me.addWord("ryan");
        me.addWord("ryannayr");

        final LinkedList<String> r = me.getWordsWithPrefix("rya");
        System.out.println(r.size());

        for(String s : r) { 
            System.out.println(s);
        }
    }
}
