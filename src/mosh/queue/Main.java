package mosh.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);
        queue.add(65);
        System.out.println(queue);


        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        System.out.println(arrayQueue);
        int decVal = arrayQueue.dequeue();
        System.out.println(decVal);
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        System.out.println("isEmpty => " + arrayQueue.isEmpty());
        System.out.println("isFull => " + arrayQueue.isFull());

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        System.out.println("isEmpty => " + arrayQueue.isEmpty());
        System.out.println("isFull => " + arrayQueue.isFull());


        ArrayQueueNew arrayQueueNew =new ArrayQueueNew(5);
        System.out.println(arrayQueueNew);
        arrayQueueNew.enqueue(66);
        arrayQueueNew.enqueue(77);
        arrayQueueNew.dequeue();
        arrayQueueNew.dequeue();
        arrayQueueNew.enqueue(88);
        arrayQueueNew.enqueue(88);
        arrayQueueNew.enqueue(88);
        System.out.println(arrayQueueNew);
        System.out.println(arrayQueueNew);
        arrayQueueNew.enqueue(66);
        arrayQueueNew.enqueue(77);
        System.out.println(arrayQueueNew);

        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(10);
        stackQueue.enqueue(30);
        stackQueue.enqueue(40);
        System.out.println(stackQueue);
        var dec =   stackQueue.dequeue();
        System.out.println(dec);
        System.out.println(stackQueue);


        java.util.PriorityQueue<Integer> priorityQueueJava=new java.util.PriorityQueue<>();
        priorityQueueJava.add(20);
        priorityQueueJava.add(30);
        priorityQueueJava.add(15);
        priorityQueueJava.add(2);
        priorityQueueJava.add(60);
        System.out.println(priorityQueueJava);
        System.out.println( priorityQueueJava.remove());

        PriorityQueue priorityQueue=new PriorityQueue( );
        priorityQueue.add(5);
        priorityQueue.add(6);
        priorityQueue.add(8);
        priorityQueue.add(7);
        priorityQueue.add(9);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue);
        priorityQueue.add(30);
        priorityQueue.add(32);
        priorityQueue.add(29);
        priorityQueue.add(50);
        System.out.println(priorityQueue);
        priorityQueue.reverseUntil(6);
        System.out.println(priorityQueue);
        priorityQueue.reverseUntil(6);
        System.out.println(priorityQueue);

        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(32);
        linkedListQueue.enqueue(65);
        linkedListQueue.enqueue(69);
        System.out.println("'linkedListQueue'" +linkedListQueue);

    }

    public static void reverseQueue(Queue<Integer> queue) {
        //add , remove , isEmpty
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
