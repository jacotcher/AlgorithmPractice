package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsertInterval {
    public static void insertInterval(int[][] existingIntervals, int[] newInterval) {
        // Read the starting and ending time of the new interval into separate variables
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        System.out.println("The new interval starts at " + newStart + " and ends at " + newEnd + ".");

        // Initialize variables to help in iterating over the existing intervals list
        int i = 0;
        int n = existingIntervals.length;
        System.out.println("There are " + n + " intervals present in the list already.");

        // Initialize an empty list to store the output
        List<int[]> output = new ArrayList<>();

        // Append all intervals that start before the new interval to the output list
        System.out.println("Let's start adding these intervals into our output list one by one, until we come across an overlapping interval.");
        System.out.println(new String(new char[100]).replace('\0', '-'));

        while (i < n && existingIntervals[i][0] < newStart) {
            output.add(existingIntervals[i]);
            i += 1;
        }

        System.out.println("The current output list of intervals without any overlapping intervals is: " + Arrays.deepToString(output.toArray()));

        // If the new interval starts after the end of the last interval appended to the output list,
        // just append the new interval to the output list.
        if (output.size() == 0 || output.get(output.size() - 1)[1] < newStart) {
            output.add(newInterval);
        } else {
            // Otherwise, merge the two intervals
            output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], newEnd);
        }

        System.out.println("The output after merging this overlapping interval will be: " + Arrays.deepToString(output.toArray()));
        i += 1;
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }



}
