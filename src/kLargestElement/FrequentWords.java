package kLargestElement;

import java.sql.Array;
import java.util.*;

public class FrequentWords {
    public static List<String> topKFrequent(String[] arr, int k) {

        if (arr.length == 0) {
            return null;
        }

        HashMap<String, Integer> freqs = new HashMap<>();

        for (String s : arr) {
            freqs.merge(s, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(FrequentWords::lowFreqHighAlpha);

        for (Map.Entry<String, Integer> word: freqs.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(word);
            } else if (lowFreqHighAlpha(minHeap.peek(), word) < 0) {
                minHeap.poll();
                minHeap.add(word);
            }
        }

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

    private static int lowFreqHighAlpha(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        if (a.getValue() < b.getValue()) {
            return -1;
        } else if (a.getValue().equals(b.getValue())) {
            return b.getKey().compareTo(a.getKey());
        }
        else {
            return 1;
        }
    }
}
