import java.util.Scanner;
import java.util.Arrays;

/** 
 * Program to return the most number of meetings that can be attended
 * given an array of meetings. 
 * Project specifications: each meeting is an array of two ints: the start and end time
 * Meetings do not overlap if the start time of one meeting is the end time of another */

public class Meetings { 
    public static void main(String[] args) { 
        final int[][] meetingList1 = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 5}, new int[]{4, 5}};

        System.out.println("Original: " + Arrays.toString(meetingList1));

        sort(meetingList1);

        System.out.println("Modified: " + Arrays.toString(meetingList2));
    }

    /** Sorts the array using Insertion Sort because, according to project specifications,
     * the # of meetings is less than 100
     * Sorts meetings in chronological order (based on meeting start time) */
    public static void sort(final int[] array) { 
        for(int i = 1; i < array.length; i++) { 
            final int startTime = array[i][0];

            int temp = i - 1;

            while((temp >= 0) && (array[temp][0] > startTime)) { 
                array[temp + 1] = array[temp];
                temp--;
            }

            array[temp + 1] = array[i];
        }
    }
}
