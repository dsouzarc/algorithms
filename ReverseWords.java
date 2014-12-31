import java.util.Stack;

/** 
 * Written by Ryan D'souza
 * Reverses the words in a String */

public class ReverseWords { 

    public static String reverseWords(final String original) { 

        //To hold the result
        final StringBuilder result = new StringBuilder("");

        //Letters for reversing
        final Stack<Character> letters = new Stack<Character>();

        //Iterate through every letter
        for(Character c : original.toCharArray()) { 

            letters.push(c);

            //If it is a space, the word has ended
            if(c == ' ') { 

                //So add everything from the stack back
                while(!letters.isEmpty()) { 
                    result.append(letters.pop());
                }
            }

        }
        return result.toString();
    }

    public static void main(String[] ryan) { 

        final StringBuilder sentence = new StringBuilder("");

        for(String r : ryan) { 
            sentence.append(r + " ");
        }

        System.out.println(reverseWords(sentence.toString()));
    }
}
