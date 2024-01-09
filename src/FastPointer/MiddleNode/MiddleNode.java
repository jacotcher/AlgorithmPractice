package FastPointer.MiddleNode;

import FastPointer.CycleDetection.LinkedListNode;

public class MiddleNode{
    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
}
