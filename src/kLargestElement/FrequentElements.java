package kLargestElement;

import java.util.*;

public class FrequentElements{
    public static List<Integer> topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> freqs = new HashMap<>();

        for (int i = 0; i < arr.length; i ++) {
            freqs.merge(arr[i], 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> freq: freqs.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(freq);
            }
            else {
                if (freq.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(freq);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> next = minHeap.poll();
            result.add(next.getKey());
        }
        return result;
    }
}