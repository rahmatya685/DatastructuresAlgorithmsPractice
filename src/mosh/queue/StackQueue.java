package mosh.queue;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> firstStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    private int count = 0;

    public void enqueue(int item) {
        firstStack.push(item);
        count++;
    }

    public int dequeue() {
        if (secondStack.empty()) {
            for (int i = 0; i < firstStack.size(); i++) {
                var item =firstStack.pop();
                secondStack.push( item);
            }
        }
        count--;
        return secondStack.pop();
    }


    @Override
    public String toString() {
        int[] arr = new int[count];
        int counter = 0;
        for (Integer integer : firstStack) {
            arr[counter] = integer;
            counter++;
        }
        for (Integer integer : secondStack) {
            arr[counter] = integer;
            counter++;
        }

        return Arrays.toString(arr);
    }
}
