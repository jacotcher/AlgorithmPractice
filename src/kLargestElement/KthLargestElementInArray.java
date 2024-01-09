package kLargestElement;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

        for (int i = 0; i < nums.length; i ++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            }
            else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.poll();
    }
}
