package StacksQueues;

// FIFO
class Node {
    int value = value;
    Node next = null;
}

public class Queue {
    Node first = null;
    Node last = null;
    int size = 0;

    public Queue() {
        this.first = first;
        this.last = last;
        this.size = size;
    }

    public Stack enqueue(int value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        return ++this.size;
    }

    public int dequeue() {
        if (this.size == 0) {
            return null;
        }
        Node removedNode = this.first;
        if (this.first == this.last) {
            this.last = null;
        }
        this.first = this.first.next;
        this.size--;
        return removedNode.value;
    }
}