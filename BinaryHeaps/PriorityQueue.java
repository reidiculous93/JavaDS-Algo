class PriorityQueue {
    int[] values;

    public PriorityQueue() {
        this.values = new int[];
    }

    public enqueue(int val, int priority) {
        Node newNode = new Node(val, priority);
        this.values.push(newNode);
        this.bubbleUp();
    }

    public dequeue() {
        Node min = this.values[0];
        int end = this.values.pop();
        if (this.values.length > 0) {
            this.values[0] = end;
            this.sinkDown();
        }
        return min;
    }

    public void bubbleUp() {
        int index = this.values.length - 1;
        int element = this.values[index];
        while (index > 0) {
            int parentIdx = Math.floor((index - 1) / 2);
            int parent = this.values[parentIdx];
            if (element.priority >= parent.priority) {
                break;
            }
            this.values[parentIdx] = element;
            this.values[index] = parent;
            index = parentIdx;
        }
    }

    public void sinkDown() {
        int idx = 0;
        int len = this.values.length;
        int element = this.values[0];

        while (true) {
            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            int left, right;
            int swap = null;
            if (leftChildIdx < len) {
                left = this.values[leftChildIdx];
                if (left.priority < element.priority) {
                    swap = leftChildIdx;
                }
            }
            if (rightChildIdx < len) {
                right = this.values[rightChildIdx];
                if(
                        (swap == null && right.priority < element.priority) ||
                        (swap != null && right.priority < left.priority))
                {
                    swap = rightChildIdx;
                }
            }
            if (swap == null) break;
            this.values[idx] = this.values[swap];
            this.values[swap] = element;
            idx = swap;
        }
    }
}

public class Node {
    int value;
    int priority;

    public Node(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}