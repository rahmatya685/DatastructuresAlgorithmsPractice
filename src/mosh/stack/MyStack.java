package mosh.stack;

public class MyStack {
    int size = 0;
    int[] array = new int[10];

    public void MyStack() {

    }

    public int pop() {
        var value =  array[size];
        array[size] = -1;
        size--;
        return value;
    }
}
