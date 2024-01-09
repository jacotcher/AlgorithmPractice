package FastPointer.CycleDetection;

import java.util.*;

public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {

        LinkedListNode left = head;
        LinkedListNode right = left.next;

        while (right.next != null) {
            if (left == right) {
                return true;
            }
            left = left.next;
            right = right.next;
            if (right.next == null) {
                return false;
            }
            right = right.next;
        }

        return false;
    }
}