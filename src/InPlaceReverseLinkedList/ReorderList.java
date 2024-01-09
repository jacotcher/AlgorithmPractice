package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedListNode;

public class ReorderList {
    public static LinkedListNode reorderList(LinkedListNode head) {

        LinkedListNode fast = head;
        LinkedListNode slow = head;
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = slow;

        LinkedListNode prev = dummy;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode middleNodePrev = prev;

        LinkedListNode curr = prev.next;
        prev = null;
        while (curr != null) {
            LinkedListNode tmpNext = curr.next;

            curr.next = prev;

            prev = curr;
            curr = tmpNext;
        }

        LinkedListNode first = head;
        LinkedListNode second = prev;
        LinkedListNode temp = head;

        while (second.next != null) {
            temp = temp.next;

            first.next = second;
            second = second.next;

            first.next.next = temp;
            first = first.next.next;
        }

        return head;
    }
}
