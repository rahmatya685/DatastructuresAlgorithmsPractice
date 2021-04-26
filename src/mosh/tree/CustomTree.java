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
            var child = value > initial.data ? initial.right : initial.left;
            if (child == null) {
                if (value > initial.data)
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
            if (value > initial.data)
                initial = initial.right;
            else if (value < initial.data)
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
        while (current != null && current.data != node.data) {
            System.out.println(current.toString());
            current = current.data > node.data ? current.left : current.right;
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

    public int minValue() {
        return minBinarySearchRecursion(root);
    }


    public int minInBinarySearchIteration() {
        return minInBinarySearchIteration(root);
    }

    /**
     * Finds minimum value in a binary search tree using iteration
     * in a binary search tree, the left most node is minimum and
     * the right most node is maximum
     *
     * @param node
     * @return
     */
    private int minInBinarySearchIteration(Node node) {
        if (node == null)
            throw new IllegalStateException();

        var current = node;
        var last = current;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.data;
    }

    /**
     * for binary search tree using recursion
     *
     * @param root
     * @return minimum value in a binary search tree
     */
    private int minBinarySearchRecursion(Node root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return root.data;
        if (root.left != null)
            return Math.min(root.data, minBinarySearchRecursion(root.left));
        return Math.min(root.data, minBinarySearchRecursion(root.right));
    }

    /**
     * for binary tree using recursion
     *
     * @param root
     * @return minimum value in a binary tree
     */
    private int minBinaryRecursion(Node root) {

        if (isLeaf(root))
            return root.data;

        var left = minBinaryRecursion(root.left);
        var right = minBinaryRecursion(root.right);

        return Math.min(Math.min(left, right), root.data);

    }

    private boolean isLeaf(Node node) {
        return node.right == null && node.left == null;
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
        System.out.print(node.data+" ");
    }



    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public boolean equals(CustomTree n) {
        return isEqual(n.root, this.root);
    }

    private boolean isEqual(Node i, Node o) {
        if (i == null && o == null)
            return true;

        if (i != null && o != null) {
            if (i.data != o.data)
                return false;
            else {
                return isEqual(i.left, o.left) && isEqual(i.right, o.right);
            }
        } else
            return false;

    }

    public boolean isBinarySearchTree() {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    /**
     * A binary search tree is a binary tree in which the left node value is smaller then paren node value
     * and right node value is bigger that left and parent node value
     *
     * @param root Node under evaluation
     * @param min minimum value for a node
     * @param max maximum value for a node
     * @return whether given node is Binary Search Tree
     */
    private boolean checkBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;

        return checkBST(root.left, min, root.data - 1) &&
                checkBST(root.right, root.data + 1, max);

    }


    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            this.data = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + data +
                    '}';
        }


    }
}
