package KWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairs {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<List<Integer>> result = new ArrayList<>();
        int list2Pointer = 0;

        for (int i = 0; i < list1.length; i++) {
            minHeap.add(new int[]{list1[i], list2[list2Pointer]});
        }
        list2Pointer += 1;

        while (result.size() < target && !minHeap.isEmpty()) {
            if (list2Pointer < list2.length)
                for (int i = 0; i < list1.length; i++) {
                    minHeap.add(new int[]{list1[i], list2[list2Pointer]});
                }

            int[] smallestSum = minHeap.poll();
            List<Integer> pair = Arrays.asList(smallestSum[0], smallestSum[1]);
            result.add(pair);

            list2Pointer += 1;
        }

        return result;
    }
}
