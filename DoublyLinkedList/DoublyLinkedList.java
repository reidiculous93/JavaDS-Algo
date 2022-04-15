package DoublyLinkedList;

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public DoublyLinkedList push(int val) {
        Node newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return this;
        }
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.length++;
        return this;
    }

    public Node pop() {
        if (this.head == null) {
            return null;
        }
        Node tmp = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return tmp;
        }
        this.tail = tmp.prev;
        tmp.prev = null;
        this.tail.next = null;
        this.length--;
        return tmp;
    }

    public Node shift() {
        if (this.head == null) {
            return null;
        }
        Node tmp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = tmp.next;
            this.head.prev = null;
            tmp.next = null;
        }
        this.length--;
        return tmp;
    }

    public DoublyLinkedList unshift(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    public Node get(int index) { // O(N)
        if (index < 0 || index >= this.length) {
            return null;
        }
        int counter;
        Node returnedNode = new Node();
        if (index <= (this.length / 2)) {
            counter = 0;
            returnedNode = this.head;
            while (counter != index) {
                returnedNode = returnedNode.next;
                counter++;
            } } else {
            counter = this.length - 1;
            returnedNode = this.tail;
            while (counter != index) {
                returnedNode = returnedNode.prev;
                counter--;
        } }
        return returnedNode;
    }

    public Node set(int index, int val) {
        Node newNode = this.get(index);
        if (newNode != null) {
            newNode.val = val;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int val) { // O(1)
        if (index < 0 || index >= this.length) {
            return null;
        }
        if (index == 0) {
            this.unshift(val);
        }
        if (index == this.length) {
            this.push(val);
        }
        Node oneBefore = this.get(index - 1);
        Node newNode = new Node(val);
        Node tmp = oneBefore.next;
        oneBefore.next = newNode;
        newNode.prev = oneBefore;
        newNode.next = tmp;
        tmp.prev = newNode;
        this.length++;
        return true;
    }

    public Node remove(int index) { // O(1)
        if (index < 0 || index >= this.length) {
            return null;
        }
        if (index == 0) {
            this.shift();
        }
        if (index == this.length) {
            this.pop();
        }
        Node removedNode = this.get(index);
        Node beforeNode = removedNode.prev;
        Node afterNode = removedNode.next;
        afterNode.prev = beforeNode;
        beforeNode.next = afterNode;
        removedNode.next = null;
        removedNode.prev = null;
        this.length--;
        return removedNode;
    }
}
