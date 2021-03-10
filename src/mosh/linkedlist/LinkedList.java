package mosh.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int count = 0;


    public void addFirst(int value) {
        var newNode = new Node(value);
        if (isEmpty())
            first = last = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
        count++;
    }

    public void addLast(int value) {
        var newNode = new Node(value);
        if (isEmpty())
            first = last = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
        count++;
    }

    public void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first.value == last.value)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        count--;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }
        count--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (node == current.next) return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        int idx = -1;
        var node = first;
        while (node != null) {
            idx++;
            if (node.value == value)
                return idx;
            node = node.next;
        }
        return -1;
    }

    public int size() {
        return count;
    }

    public void reverse() {
        var tempLast = last;
        var current = first;
        Node prevNode = null;
        while (current != null) {
            var temp = current.next;
            current.next = prevNode;
            prevNode = current;
            current = temp;
        }
        last = first;
        first = tempLast;
    }

    public int kthNodeFromEnd2(int k) {
        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            a = a.next;
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public boolean hasLoop() {


        var fast = first;
        var slow = first;
        while (true) {
            if (first == null)
                return false;
            slow = slow.next;
            if (slow == null)
                return false;

            fast = fast.next.next;

            if (fast == null)
                return false;

            if (fast == slow)
                return true;
        }
    }

    public void printMiddle() {
        var slowPointer = first;
        var fastPointer = first;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println("printMiddle=> " + slowPointer.value);
    }

    public int kthNodeFromEnd(int indexFromEnd) {
        var current = first;
        Node endNode = null;
        int endValue = -1;
        int counter = 0;
        int counter2 = 0;

        while (current != null) {
            if (counter - counter2 == indexFromEnd) {
                if (endNode == null)
                    endNode = first;
                else
                    endNode = endNode.next;

                endValue = endNode.value;
                counter2++;
            }

            current = current.next;
            counter++;
        }

        return endValue;
    }

    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder("[");
        if (first != null) {
            retVal.append(first.value);
            Node temp = first.next;
            while (temp != null) {
                if (retVal.length() > 1)
                    retVal.append(",");
                retVal.append(temp.value);
                temp = temp.next;
            }
        }
        retVal.append("]");
        return retVal.toString();
    }

    public int[] toArray() {
        int[] arr = new int[count];
        if (isEmpty())
            return arr;
        var current = first;
        int counter = 0;
        while (current != null) {
            arr[counter++] = current.value;
            current = current.next;
        }
        return arr;
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }

}
