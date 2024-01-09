package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedListNode;

public class SwapNodes {
    public static LinkedListNode swapNodes(LinkedListNode head, int k) {

        LinkedListNode curr = head;
        LinkedListNode start = head;
        LinkedListNode end = head;
        int count = 1;

        while (curr != null) {
            if (count == k) {
                start = curr;
            }
            else if (count > k) {
                end = end.next;
            }

            curr = curr.next;
            count += 1;
        }

        int tmp = start.data;

        start.data = end.data;
        end.data = tmp;

        return head;
    }
}
