package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedListNode;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {

        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = null;

        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        curr.next = prev;

        return curr;
    }
}
