package mosh.tree;

public class CustomTree {

    private Node root;

    public void insert(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        var initial = root;
        while (initial != null) {
            var child = value > initial.value ? initial.rightChild : initial.leftChild;
            if (child == null) {
                if (value > initial.value)
                    initial.rightChild = newNode;
                else
                    initial.leftChild = newNode;
            }
            initial = child;
        }
    }

    public boolean find(int value) {
        var initial = root;
        while (initial != null) {
            if (value > initial.value)
                initial = initial.rightChild;
            else if (value < initial.value)
                initial = initial.leftChild;
            else
                return true;
        }
        return false;
    }

    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
