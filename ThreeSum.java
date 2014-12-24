import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Written by Ryan D'souza
 * Finds three numbers in a sorted array whose sum = 0
 * Worst case time: O(N^2)
 
 Run Instructions:
 1. javac ThreeSum.java
 2. java ThreeSum -1 0 1 2 -1 -4
 * */

public class ThreeSum { 

    //This method prints out the first instance when sum = 0 (worst time = O(N^2)
    public static void print3Sum(final Integer[] array) { 

        //Last element of the array
        int later = array.length - 1;

        //Go to from start to last
        for(int i = 0; i < array.length; i++) { 

            //Second search through
            for(int y = i + 1; y < array.length - 1 && y < later; y++) { 

                //Print values if sum = 0
                if(array[i] + array[y] + array[later] == 0) { 
                    System.out.println(array[i] + "\t + " + array[y] + "\t + " + array[later] + "\t = 0");
                }
            }

            later--;
        }
    }

    //Prints all instances when sum = 0 (best/worst/avergae time = O(N^2)) 
    public static void print3SumAll(final Integer[] array) { 

        //To hold all the elements
        final HashSet<Integer> values = new HashSet<Integer>(Arrays.asList(array));
        final int numElements = values.size();

        //For counting how many elements we've iterated through
        int counter = 1;

        //Look through all the elements
        for(Integer first : values) { 

            //But stop one from the end
            if(counter == numElements) { 
                return;
            }

            //This finds the second number
            final Iterator<Integer> miniIterator = values.iterator();

            //Fast forward to where we are now
            for(int i = 0; i < counter; i++) { 
                miniIterator.next();
            }

            //Second number
            final int second = miniIterator.next();

            //first + second + third = 0 --> third = -first - second
            final int third = -1 * (first + second);

            //if the third number is there
            if(values.contains(third)) { 
                System.out.println(first + "\t + " + second + "\t + " + third + "\t = 0");
            }

            counter++;
        }
    }

    public static void main(String[] ryan) { 
        final Integer[] values = new Integer[ryan.length];
        for(int i = 0; i < ryan.length; i++) { 
            values[i] = Integer.parseInt(ryan[i]);
        }

        //Array must be sorted
        Arrays.sort(values);

        System.out.println("\nValues\t" + Arrays.toString(values));

        //Print all 3 sums
        print3Sum(values);

        System.out.println("\nUsing HashSet\n");
        print3SumAll(values);
    }
}
