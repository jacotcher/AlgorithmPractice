package InPlaceReverseLinkedList;

import FastPointer.CycleDetection.LinkedList;
import FastPointer.CycleDetection.LinkedListNode;

public class ReverseNodesInEventLengthGroup {
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head)
    {
        // Node immediately before the current group
        LinkedListNode prev = head;
        LinkedListNode node, reverse, currNext, curr, prevNext = null;

        // The head doesn't need to be reversed since it's a group of one node,
        // so starts with length 2
        int groupLen = 2;
        int numNodes = 0;
        while(prev.next!= null)
        {
            node = prev;
            numNodes = 0;

            // traversing all the nodes of the current group
            for (int i = 0; i < groupLen; i ++)
            {
                if(node.next == null)
                    break;
                numNodes += 1;
                node=node.next;
            }

            // odd length
            if(numNodes % 2 != 0) {
                prev = node;
            }

            // even length
            else {
                reverse = node.next;
                curr = prev.next;
                for(int j=0; j < numNodes;j++){
                    currNext = curr.next;
                    curr.next = reverse;
                    reverse = curr;
                    curr = currNext;
                }

                // updating the prev pointer after reversal of the even group
                prevNext = prev.next;
                prev.next = node;
                prev = prevNext;
            }

            // increment 1 by one and move to the next group
            groupLen += 1;
        }
        return head;
    }
}
