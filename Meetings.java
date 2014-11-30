import java.util.Scanner;
import java.util.Arrays;

/** 
 * Program to return the most number of meetings that can be attended
 * given an array of meetings. 
 * Project specifications: each meeting is an array of two ints: the start and end time
 * Meetings do not overlap if the start time of one meeting is the end time of another */

public class Meetings { 
    public static void main(String[] args) { 
        //final int[][] meetingList1 = new int[][]{new int[]{2, 3}, new int[]{0, 1}, new int[]{3, 4}, new int[]{1, 2}, new int[]{4, 5}};
        final int[][] meetingList1 = new int[][]{new int[]{0, 10000}, new int[]{42, 43}, new int[]{0, 10000}, new int[]{42, 43}};
        System.out.println("Original");
        print(meetingList1);
        sort(meetingList1);

        System.out.println("\nModified");
        print(meetingList1);

        System.out.println("\nMaximum meetings: " + mostMeetings(meetingList1));
    }

    /** Returns the most number of meetings that can be attended */
    public static int mostMeetings(final int[][] meetings) { 
        int meetingCounter = 0;

        for(int i = 0; i < meetings.length - 1; i++) { 
            //If this & the next meeting's times are good (end of first meeting, start of second)
            if(meetings[i][1] <= meetings[i + 1][0]) { 
                meetingCounter++;
            }
        }

        return meetingCounter;
    }

    /** Sorts the array using Insertion Sort because, according to project specifications,
     * the # of meetings is less than 100
     * Sorts meetings in chronological order (based on meeting start time) */
    public static void sort(final int[][] array) { 
        for(int i = 1; i < array.length; i++) { 
            final int[] temp = array[i];
            int j = i;
            while(j > 0 && array[j - 1][0] > temp[0]) { 
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public static void print(final int[][] array) { 
        for(int i = 0; i < array.length; i++) { 
            System.out.print(Arrays.toString(array[i]) + "\t");
        }
    }
}
