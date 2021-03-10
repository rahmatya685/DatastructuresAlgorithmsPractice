package hackerrank;

import java.io.IOException;

class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int i) {
        this.data = i;
    }
}

public class ReversLinkedList {

    public static void main(String[] args) throws IOException {
        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(1);
        singlyLinkedListNode.next = new SinglyLinkedListNode(3);
        singlyLinkedListNode.next.next = new SinglyLinkedListNode(8);
        singlyLinkedListNode.next.next.next = new SinglyLinkedListNode(65);
        singlyLinkedListNode.next.next.next.next = new SinglyLinkedListNode(902);
        SinglyLinkedListNode reversed = reverseUsingRecursive(singlyLinkedListNode);
        SinglyLinkedListNode current = reversed;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode newHead = null;
        while (current != null) {
            SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(current.data);
            singlyLinkedListNode.next = newHead;
            newHead = singlyLinkedListNode;
            current = current.next;
        }
        return newHead;
    }

    static SinglyLinkedListNode newHead = null;

    static SinglyLinkedListNode reverseUsingRecursive(SinglyLinkedListNode head) {
        if (head != null) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(head.data);
            if (newHead != null) {
                newNode.next = newHead;
            }
            newHead = newNode;
            reverseUsingRecursive(head.next);
        }
        return newHead;
    }

    static SinglyLinkedListNode reverseUsingRecursive2(SinglyLinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        SinglyLinkedListNode rest = reverseUsingRecursive(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

}
