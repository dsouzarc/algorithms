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

    /** Returns only the immediate characters after prefix that form a valid word (ex. Prefix = "be", returns ['a', 'd', 'e'] for "beaches", "bed", "bee", etc.) */
    public Character[] getCharsAfterPrefix(final String prefix) { 
        TrieNode valNodes = root;

        //Get to last character's node
        for(Character c : prefix.toCharArray()) { 
            valNodes = valNodes.getNode(c);
        }

        //Get all the characters below
        final LinkedList<Character> nextLetters = new LinkedList<Character>();
        final TrieNode[] children = valNodes.children;

        for(TrieNode node : children) { 
            if(node != null && node.value != ' ') { 
                nextLetters.add(node.value);
            }
        }

        return nextLetters.toArray(new Character[nextLetters.size()]);
    }

    public String[] getWordsWithPrefix(final String prefix) { 
        TrieNode valNodes = root;

        for(Character c : prefix.toCharArray()) { 
            valNodes = valNodes.getNode(c);

            if(valNodes == null) {
                return new String[]{}; 
            }
        }
        final LinkedList<String> vals = valNodes.getWords();
        return vals.toArray(new String[vals.size()]);
    }

    public static void main(String[] ryan) { 
        Trie me = new Trie();
        me.addWord("ryan");
        me.addWord("ryannayr");

        final String[] r = me.getWordsWithPrefix("rya");

        for(String s : r) { 
            System.out.println(s);
        }
    }
}
