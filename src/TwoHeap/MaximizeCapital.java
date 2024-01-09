package TwoHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int n = capitals.length;
        int currentCapital = c;

        PriorityQueue<int[]> capitalminHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            capitalminHeap.add(new int[]{capitals[i], i});
        }

        PriorityQueue<int[]> profitsmaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int count = 0;

        // While number of projects is below our k
        while (count < k) {
            // If no projects with current capital, then break the loop
            if (!capitalminHeap.isEmpty() && capitalminHeap.peek()[0] <= currentCapital) {
                // Get list of possible projects (adding new ones we can afford)
                do {
                    int[] project = capitalminHeap.poll();
                    profitsmaxHeap.add(new int[]{profits[project[1]]});
                    if (capitalminHeap.size() == 0) {
                        break;
                    }
                } while (capitalminHeap.peek()[0] <= currentCapital);
            }

            // Add new max projects profit to the currentCapital
            if (!profitsmaxHeap.isEmpty()) {
                currentCapital += profitsmaxHeap.poll()[0];
            }

            count ++;
        }
        return currentCapital;
    }
}
