package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedListNode;

public class SwapNodesInPairs {
    public static LinkedListNode swapPairs(LinkedListNode head) {

        LinkedListNode curr = head;

        while (curr != null && curr.next != null) {
            int temp = curr.data;
            LinkedListNode currNext = curr.next;
            curr.data = currNext.data;
            currNext.data = temp;
            curr = curr.next.next;
        }

        return head;
    }
}
