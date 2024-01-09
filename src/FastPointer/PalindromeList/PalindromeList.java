package FastPointer.PalindromeList;

import FastPointer.CycleDetection.LinkedListNode;

public class PalindromeList{
    public static boolean palindrome(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode mid = slow;

        LinkedListReversal.reverseLinkedList(mid.next);

        fast = head;

        while (fast != null) {
            if (fast != slow) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }
}
