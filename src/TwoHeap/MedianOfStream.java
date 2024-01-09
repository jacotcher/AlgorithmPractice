package TwoHeap;

import java.util.PriorityQueue;

public class MedianOfStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfStream() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(Integer number) {
        if (this.maxHeap.peek() == null) {
            this.maxHeap.add(number);
        } else if (number < this.maxHeap.peek()) {
            this.maxHeap.add(number);
        } else {
            this.minHeap.add(number);
        }

        if (this.maxHeap.size() > this.minHeap.size() + 1) {
            this.minHeap.add(this.maxHeap.poll());
        } else if (this.minHeap.size() > this.maxHeap.size()) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public double findMedian() {
        if (this.maxHeap.peek() == null) {
            return 0;
        }
        if (this.maxHeap.size() == this.minHeap.size()) {
            return ((double) this.maxHeap.peek() + (double) this.minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
