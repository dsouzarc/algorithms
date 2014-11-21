import java.util.LinkedList;

/** 
 * Written by Ryan D'souza
 * Represents a TrieNode, the element
 * that composes a Trie list for storing
 * words from a dictionary */

public class TrieNode { 
    private TrieNode[] children;
    private TrieNode parent;

    //Last character of word
    private boolean isWord;

    //Other children
    private boolean isLeaf;

    private char value;

    /** Top level Node constructor */
    public TrieNode() { 
        this.children = new TrieNode[26];
        this.isLeaf = true;
        this.isWord  = false;
    }

    /** Children constructor */
    public TrieNode(final char value) { 
        this();
        this.value = value;
    }

    /** Recursively adds characters as child nodes */
    public void addWord(String word) { 
        word = word.toLowerCase();

        //Has children
        isLeaf = false;

        //ASCII Value
        int charPosition = word.charAt(0) - 'a';

        //If no children with that constructor exists
        if(children[charPosition] == null) { 
            //Make a new Node
            children[charPosition] = new TrieNode(word.charAt(0));
            
            //That node's parent is this
            children[charPosition].parent = this;
        }
        
        //Recursive part to add word
        if(word.length() > 1) { 
            children[charPosition].addWord(word.substring(1));
        }
        //If no more characters left, is end
        else { 
            children[charPosition].isWord = true;
        }
        System.out.println(java.util.Arrays.toString(children) + "\t" + value);
    }

    /** Return nodes associated with character */
    public TrieNode getNode(final char toGet) { 
        final int loc = (int)toGet >= 65 && (int)toGet < 97 ? (int)toGet - 65: (int)toGet - 97;
        return children[toGet - 'a'];
    }

    /** Return list of words beneath */
    public LinkedList getWords() { 
        final LinkedList words = new LinkedList();

        //If last char of word, add ourself
        if(isWord) { 
            System.out.println(toString());
            words.add(toString());
        }

        //Get all children
        if(!isLeaf) { 
            for(int i = 0; i < this.children.length; i++) { 
                if(this.children[i] != null) { 
                    //Add the child
                    words.addAll(this.children[i].getWords());
                }
            }
        }

        return words;
    }

    /** Return toString representation (goes to parent
     * and adds child nodes) */
    public String toString() { 
        if(parent == null) { 
            return "";
        }

        else { 
            return parent.toString() + new String(new char[]{value});
        }
    }
}
