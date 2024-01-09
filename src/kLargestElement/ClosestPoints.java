package kLargestElement;

import Shared.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPoints {
    public static List<Point> kClosest(Point[] points, int k) {

        PriorityQueue<Point> minHeap = new PriorityQueue<Point>((a, b) -> b.getDistanceFromOrigin() - a.getDistanceFromOrigin() > 0 ? 1 : -1);

        for (int i = 0; i < points.length; i++) {
            Point nextPoint = points[i];
            if (minHeap.size() < k) {
                minHeap.add(points[i]);
            } else {
                Point currentFurthest = minHeap.peek();
                if (nextPoint.getDistanceFromOrigin() < currentFurthest.getDistanceFromOrigin()) {
                    minHeap.poll();
                    minHeap.add(nextPoint);
                }
            }
        }

        ArrayList<Point> result = new ArrayList<Point>();
        result.addAll(minHeap);

        return result;
    }
}
