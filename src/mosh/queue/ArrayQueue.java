package mosh.queue;

import java.util.Arrays;
import java.util.Collections;

public class ArrayQueue {
    private int[] array = new int[3];
    private int count = 0;

    public void enqueue(int v) {
        array[count] = v;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int firstItem = array[0];
        for (int i = 1; i < array.length; i++)
            array[i - 1] = array[i];
        count--;
        return firstItem;
    }

    public int peek() {
        return array[0];
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public Boolean isFull() {
        return count == array.length;
    }

    @Override
    public String toString() {
        int[] newArray =   Arrays.copyOfRange(array,0,count);

        return "ArrayQueue{" +
                "array=" + Arrays.toString(newArray) +
                ", count=" + count +
                '}';
    }
}
