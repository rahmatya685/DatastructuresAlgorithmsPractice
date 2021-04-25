package mosh.tree;

public class CustomTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        var initial = root;
        while (initial != null) {
            var child = value > initial.val ? initial.right : initial.left;
            if (child == null) {
                if (value > initial.val)
                    initial.right = newNode;
                else
                    initial.left = newNode;
            }
            initial = child;
        }
    }

    public boolean find(int value) {
        var initial = root;
        while (initial != null) {
            if (value > initial.val)
                initial = initial.right;
            else if (value < initial.val)
                initial = initial.left;
            else
                return true;
        }
        return false;
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public int height() {
        return height(root.right);
    }

    /*height(7)
     * 1+max(height(4),height(9)) => 1+max(1,1) => 2
     *   1+max(height(1),height(6)) =>   1+ max(0,0) => 1
     *     0
     *   1+max(height(8),height(10)) =>  1+ max(0,0) => 1
     *     0
     */
    public int height(Node node) {
        if (node == null)
            return -1;
        if (node.left == null && node.right == null)
            return 0;
        return 1 + Math.max(height(node.right), height(node.left));
    }


    public int depth() {
        return depth(root);
    }


    /**
     * Start from root and traverse to the given node
     *
     * @param node
     * @return
     */
    public int depth(Node node) {
        System.out.println(node.toString());
        int depth = 0;
        var current = getRoot();
        while (current != null && current.val != node.val) {
            System.out.println(current.toString());
            current = current.val > node.val ? current.left : current.right;
            depth++;
        }
        return depth;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.right == null)
            return maxDepth(root.left) + 1;
        else
            return maxDepth(root.right) + 1;
    }

    /**
     * Visit deepest right child and then the child's parent and finally the deepest left child
     * Continue this pattern with other small nodes
     *
     * @param node
     */
    private void traversePostOrder(Node node) {
        if (node == null)
            return;
        traversePostOrder(node.right);
        traversePostOrder(node.left);
        System.out.println(node.val);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.val);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }


    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + val +
                    '}';
        }
    }
}
