/** 
 * Written by Ryan D'souza
 * PClassic Problem #6: http://pclassic.org/files/2014s/PClassic2014sProblems.pdf
 * Implementation of Diffie-Hellman Algo: http://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
 *
 * y = (g^x) (mod p);
 * Given y, g, p, and encryped password, compute x and decipher garbled characters
 *
 * Sample Input: 
 * java DiffieHellman 80,5,105,GZRDNZGGDN
 *
 * Output: 
 * LEWISELLIS 
 *
 * Sample Input: 
 * java DiffieHelman 15 6 51 ZQAUXQHJ
 *
 * Output: 
 * JAKEHART 
 * */

public class DiffieHellman { 

    public static void main(String[] ryan) { 
        final int y = Integer.parseInt(ryan[0]);
        final int g = Integer.parseInt(ryan[1]);
        final int p = Integer.parseInt(ryan[2]); 
        final String encrypted = ryan[3];

        //We know p is between 1 and 150 and x is less than that
        int x = 0;
        for(int i = 2; i < 150; i++) { 
            //If x completes the equation, we have the answer
            if(y == Math.pow(g, i) % p) { 
                x = i;
                break;
            }
        }

        //Print the new string rotated by X characters
        System.out.println(rotateBy(encrypted, x));
    }

    /** Returns a string rotated by X characters */
    public static String rotateBy(final String string, final int num) { 
        final StringBuilder result = new StringBuilder("");

        for(Character c : string.toCharArray()) {
            final int asciiVal = (int) c + num;
            if(asciiVal > 'Z') { 
                result.append((char) (asciiVal - 26));
            }
            else { 
                result.append((char) asciiVal);
            }
        }
        return result.toString();
    }
}
