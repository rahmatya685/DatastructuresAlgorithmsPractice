package mosh.queue;

import java.util.Arrays;

public class ArrayQueueNew {
    //enqueue
    //dequeue
    //isFull
    //isEmpty
    //peek

    private int count = 0;
    private int front = 0;
    private int rear = 0;

    private int[] array;

    public ArrayQueueNew(int capacity) {
        array = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException("Queue is full");


        array[rear] = item;
        rear = (rear + 1) % array.length;
        System.out.println(rear);
        count++;

    }

    public int dequeue() {

        if (isEmpty())
            throw new IllegalStateException("Queue is Empty");

        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        count--;
        return item;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "ArrayQueueNew{" +
                "count=" + count +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
