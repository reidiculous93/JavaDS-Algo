package BinarySearchTrees;

import java.util.*;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return this;
        } else {
            Node curr = this.root;

            while (true) {
                if (value == curr.value) {
                    return null;
                }
                if (value < curr.value) {
                    if (curr.left == null) {
                        curr.left = newNode;
                        return this;
                    } else {
                        curr = curr.left;
                    }
                } else if (value > curr.value) {
                    if (curr.right == null) {
                        curr.right = newNode;
                        return this;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }
    }

    public Node search(int value) {
        boolean found;
        Node curr;
        if (this.root == null) {
            return null;
        } else {
            curr = this.root;
            found = false;
            while (curr != null) {
                if (value > curr.value) {
                    curr = curr.right;
                } else if (value < curr.value) {
                    curr = curr.left;
                } else {
                    found = true;
                    break;
                }
            }
        }
        if (!found) return null;
        return curr;
    }

    public List<Node> BFS() {
        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
             Node curr = queue.remove();
             if (curr.left != null) {
                 queue.add(curr.left);
             }
             if (curr.right != null) {
                 queue.add(curr.right);
             }
        }
        return list;
    }

    public void DFSPreOrder(Node node) {
        while (node != null) {
            if (node.left != null) {
                DFSPreOrder(node.left);
            }
            if (node.left != null) {
                DFSPreOrder(node.right);
            }
        }
    }

    public void DFSPostOrder(Node node) {
        List<Integer> data = new ArrayList<>();
        if (node.left != null) {
            DFSPostOrder(node.left);
        }
        if (node.right != null) {
            DFSPostOrder(node.right);
        }
        data.add(node.value);
        DFSPostOrder(this.root);
    }

    public void DFSInorder(Node node) {
        List<Integer> data = new ArrayList<>();
        if (node.left != null) {
            DFSInorder(node.left);
        }
        data.add(node.value);
        if (node.right != null) {
            DFSInorder(node.right);
        }
        DFSInorder(this.root);
    }
}