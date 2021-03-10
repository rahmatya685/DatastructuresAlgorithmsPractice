package hackerrank;

public class MergeTwoLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(4);
        singlyLinkedListNode.next = new SinglyLinkedListNode(5);
        singlyLinkedListNode.next.next = new SinglyLinkedListNode(6);

        SinglyLinkedListNode singlyLinkedListNode2 = new SinglyLinkedListNode(1);
        singlyLinkedListNode2.next = new SinglyLinkedListNode(2);
        singlyLinkedListNode2.next.next = new SinglyLinkedListNode(10);

        SinglyLinkedListNode result = mergeLists2(singlyLinkedListNode, singlyLinkedListNode2);

        while (result != null) {
            System.out.println("result: " + result.data);
            result = result.next;
        }
    }


    static SinglyLinkedListNode mergeLists2(SinglyLinkedListNode currA, SinglyLinkedListNode currB) {

        if (currA == null) {
            return currB;
        } else if (currB == null) {
            return currA;
        }

        /* Find new head pointer */
        SinglyLinkedListNode head = null;
        if (currA.data < currB.data) {
            head = currA;
            currA = currA.next;
        } else {
            head = currB;
            currB = currB.next;
        }

        /* Build rest of list */
        SinglyLinkedListNode n = head;
        while (currA != null && currB != null) {
            if (currA.data < currB.data) {
                n.next = currA;
                currA = currA.next;
            } else {
                n.next = currB;
                currB = currB.next;
            }
            n = n.next;
        }

        /* Attach the remaining elements */
        if (currA == null) {
            n.next = currB;
        } else {
            n.next = currA;
        }

        return head;
    }

    /*
     * For your reference:
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.data < head2.data) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }
    }
}
