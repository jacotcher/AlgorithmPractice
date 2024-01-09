package kLargestElement;

import java.util.*;
public class KthLargest {
    PriorityQueue<Integer> topKHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.topKHeap = new PriorityQueue<>((a, b) -> a-b);
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (this.topKHeap.size() < this.k) {
            this.topKHeap.add(val);
            return -1;
        }
        if (val > this.topKHeap.peek()) {
            this.topKHeap.poll();
            this.topKHeap.add(val);
        }
        return this.topKHeap.peek();
    }
}