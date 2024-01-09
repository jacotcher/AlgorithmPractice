package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedListNode;

public class ReverseLinkedListBetweenLnR {
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {

        LinkedListNode leftNode = null;
        LinkedListNode leftNodePrev = null;
        LinkedListNode rightNode = null;
        LinkedListNode curr = head;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = curr;
        LinkedListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        leftNode = curr;
        leftNodePrev = prev;

        for (int i = left; i < right; i++) {
            prev = curr;
            curr = curr.next;
        }
        rightNode = curr;
        LinkedListNode rightNodeNext = rightNode.next;

        curr = leftNode.next;
        prev = leftNode;
        LinkedListNode next = null;


        for (int i = left; i < right; i++) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }


        leftNodePrev.next = rightNode;
        leftNode.next = rightNodeNext;

        return dummy.next;

    }
}
