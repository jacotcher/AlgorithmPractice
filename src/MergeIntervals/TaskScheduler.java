package MergeIntervals;

import java.util.*;

public class TaskScheduler {
    public static int leastTime(char[] tasks, int n) {

        HashMap<Character, Integer> charFreqs = new HashMap<>();

        for (char task : tasks) {
            charFreqs.merge(task, 1, Integer::sum);
        }

        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(charFreqs.entrySet());
        Collections.sort(sortedFrequencies, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        int idleTime = (maxFreq - 1) * n;;

        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }
        idleTime = Math.max(0, idleTime);

        // Return the total time, which is the sum of the busy time and idle time
        return tasks.length + idleTime;
    }
}