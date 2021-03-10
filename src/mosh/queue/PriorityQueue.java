package mosh.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array = new int[5];
    private int count;

    public void add(int item) {

        if (count == array.length) {
            resizeArray();
        }

        int i;
        for (i = (count - 1); i >= 0; i--) {
            if (array[i] > item)
                array[i + 1] = array[i];
            else break;
        }
        array[i + 1] = item;
        count++;
    }

    public int remove() {
        var firstItem = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        count--;
        return firstItem;
    }

    public void reverseUntil(int index) {
        for (int i = 0; i < (index % 2 == 0 ? index / 2 : (index / 2) +1); i++) {
            var temp = array[index - i];
            array[index - i] = array[i];
            array[i] = temp;
        }
    }

    private void resizeArray() {
        var temp = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
