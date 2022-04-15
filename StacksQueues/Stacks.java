package StacksQueues;

// LIFO Last in First out
class Node {
    int value = value;
    Node next = null;
}

public class Stack {
    Node first = null;
    Node last = null;
    int size = 0;

    public Stack() {
        this.first = first;
        this.last = last;
        this.size = size;
    }

    public Stack push(int value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            Node tmp = this.first;
            this.first = newNode;
            this.first.next = tmp;
        }
        return ++this.size;
    }

    public int pop() {
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