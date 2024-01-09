package MergeIntervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static int findSets(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        minHeap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];

            while (minHeap.peek() != null && currentInterval[0] > minHeap.peek()[1]) {
                minHeap.poll();
            }
            minHeap.add(currentInterval);

        }

        return minHeap.size();
    }
}
