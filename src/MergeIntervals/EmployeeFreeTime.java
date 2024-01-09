package MergeIntervals;

import Shared.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//You’re given a list containing the schedules of multiple employees.
// Each person’s schedule is a list of non-overlapping intervals in sorted order.
// An interval is specified with the start and end time, both being positive integers.
// Your task is to find the list of finite intervals representing the free time for all the employees.
public class EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < schedule.size(); i++) {
            heap.add(new int[]{schedule.get(i).get(0).getStart(), schedule.get(i).get(0).getEnd(), i, 0});
        }

        int[] previousInterval = heap.poll();
        Interval newInterval = schedule.get(previousInterval[2]).get(1);
        heap.add(new int[]{newInterval.getStart(), newInterval.getEnd(), previousInterval[2], 1});

        while (heap.peek() != null) {
            int[] currentInterval = heap.poll();
            if (currentInterval[0] > previousInterval[1]) {
                ans.add(new Interval(previousInterval[1], currentInterval[0]));
            }

            previousInterval = maxInterval(previousInterval, currentInterval);
            Interval newInterval2 = schedule.get(previousInterval[2]).get(previousInterval[3] + 1);
            if (newInterval2.getStart() != previousInterval[0] && newInterval2.getEnd() != previousInterval[1]) {
                heap.add(new int[]{newInterval2.getStart(), newInterval2.getEnd(), previousInterval[2], 1});
            }
        }

        return ans;
    }

    private static int[] maxInterval(int[] previousInterval, int[] currentInterval) {
        if (currentInterval[1] > previousInterval[1]) {
            return currentInterval;
        } else {
            return previousInterval;
        }
    }
}
