package KWayMerge;

import FastPointer.CycleDetection.LinkedList;
import FastPointer.CycleDetection.LinkedListNode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {


        LinkedListNode[] currentNodes = new LinkedListNode[lists.size()];

        for (int i = 0; i < lists.size(); i++) {
            currentNodes[i] = lists.get(i).head;
        }

        LinkedListNode dummyNode = new LinkedListNode(0);
        LinkedListNode currentNode = dummyNode;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new int[]{currentNodes[i].data, i});
        }

        while (!minHeap.isEmpty()) {

            int[] nextLowestNode = minHeap.poll();
            LinkedListNode newNode = new LinkedListNode(nextLowestNode[0]);
            currentNode.next = newNode;
            currentNode = newNode;

            LinkedListNode nextNodeInList = currentNodes[nextLowestNode[1]].next;
            currentNodes[nextLowestNode[1]] = nextNodeInList;
            if (nextNodeInList != null)
                minHeap.add(new int[]{nextNodeInList.data, nextLowestNode[1]});
        }


        return dummyNode.next;
    }
}
