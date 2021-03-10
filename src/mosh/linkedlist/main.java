package mosh.linkedlist;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        System.out.println("size   : "+ linkedList.size());
        System.out.println("toArray   : "+ Arrays.toString(linkedList.toArray()));


        linkedList.addFirst(1);
        linkedList.addLast(25);
        linkedList.addFirst(2);
        linkedList.addFirst(65);
        linkedList.addFirst(98);
        linkedList.addFirst(885);
        linkedList.addFirst(96);

        var endNode =  linkedList.kthNodeFromEnd(6);
        System.out.println("kthNodeFromEnd   : " +endNode);

        linkedList.printMiddle();


        System.out.println("toArray   : "+ Arrays.toString(linkedList.toArray()));

        linkedList.reverse();
        System.out.println("reverse   : "+  Arrays.toString(linkedList.toArray()));

        linkedList.printMiddle();

        System.out.println("Index 5555 : "+ linkedList.indexOf(5555));
        System.out.println("Index 98 : "+ linkedList.indexOf(98));

        System.out.println("contains 98 : "+ linkedList.contains(98));
        System.out.println("contains 5555 : "+ linkedList.contains(5555));


        System.out.println(linkedList.toString());
        System.out.println("size   : "+ linkedList.size());


        linkedList.deleteLast();
        linkedList.deleteFirst();
        System.out.println("toArray   : "+  Arrays.toString(linkedList.toArray()));
        linkedList.printMiddle();
        linkedList.deleteFirst();
        System.out.println("toArray   : "+  Arrays.toString(linkedList.toArray()));

        linkedList.printMiddle();
        System.out.println(linkedList.toString());

        System.out.println("size   : "+ linkedList.size());
        System.out.println("toArray   : "+  Arrays.toString(linkedList.toArray()));


    }
}
