package Graphs;

import com.sun.jdi.IntegerValue;

import java.lang.reflect.Array;
import java.util.*;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> adjacancyList = new HashMap<>();

        // Add items to adjacency list
        for (int i = 0; i < times.length; i++) {
            int[] vertex = times[i];

            List<int[]> currentConnections = adjacancyList.getOrDefault(vertex[0], new ArrayList<>());
            currentConnections.add(new int[]{vertex[1], vertex[2]});
            adjacancyList.put(vertex[0], currentConnections);
        }

        // Create priority queue, and add our source vertext with a time of 0
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});

        // Create visisted hash set and instanciate delays to 0
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        while (!pq.isEmpty()) {
            // Get the next shortest time
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            // If we've visited it, then skip
            if (visited.contains(node))
                continue;

            // Add to visisted nodes
            visited.add(node);

            // Increase delays if visiting this node has increased the delay
            delays = Math.max(delays, time);

            // Retrieve the list of neighbours from the adjacency list
            List<int[]> neighbours = adjacancyList.getOrDefault(node, new ArrayList<>());

            for (int[] neighbour : neighbours) {

                // For each neighbour, if the neighbour hasn't been visited then add it to the prioritiy queue
                // for processing
                int neighbourNode = neighbour[0];
                int neighbourTime = neighbour[1];
                if (!visited.contains(neighbourNode)) {
                    int newTime = time + neighbourTime;
                    pq.add(new int[]{newTime, neighbourNode});
                }
            }

        }



        if (visited.size() == n)
            return delays;

        return -1;
    }
}
