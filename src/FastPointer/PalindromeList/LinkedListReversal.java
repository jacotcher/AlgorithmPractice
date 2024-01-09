package FastPointer.PalindromeList;

import FastPointer.CycleDetection.LinkedListNode;

class LinkedListReversal{
    static LinkedListNode reverseLinkedList(LinkedListNode slowPtr){
        LinkedListNode prev = null;
        LinkedListNode next = null;
        LinkedListNode curr = slowPtr;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


