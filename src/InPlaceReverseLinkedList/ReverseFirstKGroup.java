package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedListNode;

public class ReverseFirstKGroup {
    public static LinkedListNode reverseFirstKGroup(LinkedListNode head, int k) {

        int changes = 0;
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = head.next;
        LinkedListNode original = head;

        while (curr.next != null && changes < k + 1) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

            changes ++;
        }

        original.next = next;
        return prev;
    }
}
