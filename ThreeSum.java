/**
 * Written by Ryan D'souza
 * Finds three numbers in a sorted array whose sum = 0
 * Worst case time: O(N^2) */

public class ThreeSum { 
    public static void print3Sum(final int[] array) { 
        int later = array.length - 1;

        for(int i = 0; i < array.length && i < later; i++) { 
            for(int y = i + 1; y < array.length - 1 && y < later; y++) { 
                if(array[i] + array[y] + array[later] == 0) { 
                    System.out.println(array[i] + "\t + " + array[y] + "\t + " + array[later] + "\t = 0");
                }
            }

            later--;
        }
    }

    public static void main(String[] ryan) { 
        final int[] values = new int[ryan.length];

        for(int i = 0; i < ryan.length; i++) { 
            values[i] = Integer.parseInt(ryan[i]);
        }

        print3Sum(values);
    }
}
