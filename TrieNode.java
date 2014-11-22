import java.util.LinkedList;

/** 
 * Written by Ryan D'souza
 * Represents a TrieNode, the element
 * that composes a Trie list for storing
 * words from a dictionary */

public class TrieNode { 
    private final TrieNode parent;
    private final TrieNode[] children;

    //Last character of word
    private boolean isWord;

    //Other children
    private boolean hasChildren;

    //Value of this node
    private final char value;

    /** Top level Node constructor */
    public TrieNode() { 
        //26 Nodes, one for each letter of alphabet
        this.children = new TrieNode[26];

        this.hasChildren = true;
        this.isWord  = false;
        this.parent = null;
        this.value = ' ';
    }

    /** Constructor for child nodes */
    public TrieNode(final char value, final TrieNode parent) { 
        this.parent = parent;
        this.value = value;
        
        //26 Nodes, one for each letter of alphabet
        this.children = new TrieNode[26];

        this.hasChildren = true;
        this.isWord  = false;
    }

    /** Recursively adds characters as child nodes */
    public void addWord(String word) { 
        word = word.toLowerCase();

        //Has children
        this.hasChildren = false;

        //ASCII Value
        final int charPosition = word.charAt(0) - 'a';

        //If no children with that constructor exists
        if(this.children[charPosition] == null) { 

            //Make a new Node and set its parent as this one's
            this.children[charPosition] = new TrieNode(word.charAt(0), this);
        }
        
        //Recursive part to add word
        if(word.length() > 1) { 
            this.children[charPosition].addWord(word.substring(1));
        }

        //If no more characters left, is end
        else { 
           this.children[charPosition].isWord = true;
        }
    }

    /** Return nodes associated with character */
    public TrieNode getNode(final char toGet) { 
        return this.children[toGet - 'a'];
    }

    /** Return list of N words beneath */
    public LinkedList<String> getWords(final int N) { 
        final LinkedList<String> words = new LinkedList<String>();

        //If last char of word, add ourself
        if(this.isWord) { 
            words.add(this.toString());
        }

        //Get all children
        if(!this.hasChildren) { 
            for(TrieNode child : this.children) {
                if(child != null) { 
                    //Add the child
                    words.addAll(child.getWords());
                }

                //If we have more than words we need
                if(words.size() >= N) { 

                    //Return the exact amount of words we need
                    if(words.size() > N) { 
                        return (LinkedList<String>) words.subList(0, N);
                    }
                    else { 
                        return words;
                    }
                }
            }
        }
        return words;
    }

    /** Return all words beneath */
    public LinkedList<String> getWords() { 
        return getWords(Integer.MAX_VALUE);
    }

    /** Return toString representation (goes to parent
     * and adds child nodes) */
    public String toString() { 
        if(this.parent == null) { 
            return "";
        }

        else { 
            return this.parent.toString() + String.valueOf(value); 
        }
    }
}
