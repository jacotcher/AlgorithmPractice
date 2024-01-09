package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;

public class MinimumSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {

        int currentWindowSum = 0;
        int bestWindowSum = 0;
        int bestWindowSumSize = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            int currentNumAtStart = nums[start];
            int currentNumAtEnd = nums[end];


            currentWindowSum += currentNumAtEnd;


            while (start <= end && currentWindowSum >= target) {
                currentNumAtStart = nums[start];
                bestWindowSum = currentWindowSum;
                bestWindowSumSize = (end - start) + 1;
                currentWindowSum -= currentNumAtStart;
                start++;
            }
        }
        return bestWindowSumSize;
    }
}
