package mosh.queue;


import mosh.linkedlist.LinkedList;

public class LinkedListQueue {
    private Node front;
    private Node rear;

    public void enqueue(int item) {
        var temp = new Node(item);
        if (rear == null) {
            this.rear = this.front = temp;
        } else {
            this.rear.next = temp;
            this.rear = temp;
        }

    }

    public int dequeue() {
        if (front == null)
            throw new IllegalStateException("Queue is empty");

        if (front.next == null) {
            var temp = front.value;
            rear = front = null;
            return temp;
        }

        var temp = front;
        front = front.next;
        return temp.value;
    }


    private class Node {
        int value;
        Node next;

        public Node(int item) {
            this.value = item;
        }
    }

    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder("[");
        if (front != null) {
            retVal.append(front.value);
            Node temp = front.next;
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

}
