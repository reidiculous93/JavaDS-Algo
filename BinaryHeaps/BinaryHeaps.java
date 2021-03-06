class MaxBinaryHeap {
    int[] values;

    public MaxBinaryHeap() {
        this.values = new int[];
    }

    public MaxBinaryHeap insert(int element) {
        this.values.push(element);
        this.bubbleUp();
    }

    public void bubbleUp() {
        int index = this.values.length - 1;
        int element = this.values[index];
        while (index > 0) {
            int parentIdx = Math.floor((index - 1) / 2);
            int parent = this.values[parentIdx];
            if (element <= parent) {
                break
            }
            this.values[parentIdx] = element;
            this.values[index] = parent;
            index = parentIdx;
        }
    }

    public int extractMax() {
        int currMax = this.values[0];
        int end = this.values.pop();
        if (this.values.length > 0) {
            this.values[0] = end;
            this.sinkDown();
        }
        return currMax;
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
                if (left > element) {
                    swap = leftChildIdx;
                }
            }
            if (rightChildIdx < len) {
                right = this.values[rightChildIdx];
                if ((swap == null && right > element) || (swap != null && right > left)) {
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