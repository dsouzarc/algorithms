import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public final class Dictionary { 
    public Dictionary() { 
        final String fileName = "dictionary.txt";

        final StringBuilder theBuilder = new StringBuilder("");

        try { 
            final BufferedReader theReader = new BufferedReader(new FileReader(fileName));

            while(theReader.ready()) { 
                theBuilder.append(theReader.readLine() + " ");
            }

            System.out.println(theBuilder.toString());
        }

        catch(Exception e) { 
            System.out.println(e.toString());
        }
    }

    public static void main(String[] ryan) { 
        new Dictionary();
    }
}


