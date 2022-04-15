package SinglyLinkedList;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;
    Node tail;
    int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public SinglyLinkedList push(int val) {
        Node newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    public Node pop() {
        if (this.head == null) {
            return null;
        }
        Node current = this.head;
        Node newTail = current;
        while (current.next != null) {
            newTail = current;
            current = current.next;
        }
        this.tail = newTail;
        this.tail.next = null;
        this.length--;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }
        return current;
    }

    public Node shift() {
        if (this.head == null) {
            return null;
        }
        Node tmp = this.head;
        this.head = this.head.next;
        this.length--;
        if (this.length == 0) {
            this.tail = null;
        }
        return tmp;
    }

    public SinglyLinkedList unshift(int val) {
        Node newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    public Node get(int index) {
        if (index < 0 || index > this.length) {
            return null;
        }
        int counter = 0;
        Node current = this.head;
        while (counter != index) {
            current = current.next;
            counter++;
        }
        return current;
    }

    public boolean set(int index, int val) {
        Node newNode = this.get(index);
        if (newNode != null) {
            newNode.val = val;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int val) {
        if (index < 0 || index > this.length) {
            return false;
        }
        if (index == this.length) {
            this.push(val);
            return true;
        }
        if (index == 0) {
            this.unshift(val);
            return true;
        }
        Node newNode = new Node(val);
        Node prevNode = this.get(index - 1);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        this.length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        if (index == 0) {
            return this.shift();
        }
        if (index == this.length - 1) {
            return this.pop();
        }
        Node prevNode = this.get(index - 1);
        Node removed = prevNode.next;
        prevNode.next = removed.next;
        this.length--;
        return removed;
    }

    public SinglyLinkedList reverse() {
        Node node = this.head;
        this.head = this.tail;
        this.tail = node;
        Node next;
        Node prev = null;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return this;
    }
}
