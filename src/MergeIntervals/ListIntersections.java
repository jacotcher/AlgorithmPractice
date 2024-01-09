package MergeIntervals;

import java.util.ArrayDeque;

public class ListIntersections {
//    For two lists of closed intervals given as input,
//    intervalLista and intervalListb, where each interval
//    has its own start and end time,
//    write a function that returns the intersection
//    of the two interval lists.
    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        // Replace this placeholder return statement with your code
        ArrayDeque<int[]> intersections = new ArrayDeque<>();
        int aPointer = 0;
        int bPointer = 0;
        while (aPointer < intervalLista.length && bPointer < intervalListb.length) {

            int[] a = intervalLista[aPointer];
            int[] b = intervalListb[bPointer];

            if (a[0] >= b[0] && a[0] <= b[1] || b[0] >= a[0] && b[0] <= a[1]) {

                int intersectionStart = Math.max(a[0], b[0]);
                int intersectionEnd = Math.min(a[1], b[1]);
                int[] intersection = {intersectionStart, intersectionEnd};
                intersections.add(intersection);

                if (a[1] >= b[1]) {
                    bPointer++;
                }
                else {
                    aPointer++;
                }
            } else if (a[1] >= b[1]) {
                bPointer++;
            } else {
                aPointer++;
            }
        }
        int size = intersections.size();
        int counter = 0;
        int[][] intersectionsArray = new int[size][2];
        while (intersections.size() > 0) {
            intersectionsArray[counter] =intersections.remove();
            counter++;
        }
        return intersectionsArray;
    }
}
