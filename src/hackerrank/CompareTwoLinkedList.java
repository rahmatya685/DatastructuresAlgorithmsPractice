package hackerrank;

public class CompareTwoLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(1);
        SinglyLinkedListNode singlyLinkedListNode2 = new SinglyLinkedListNode(1);
        singlyLinkedListNode.next = new SinglyLinkedListNode(3);
        singlyLinkedListNode.next.next = new SinglyLinkedListNode(8);
        singlyLinkedListNode.next.next.next = new SinglyLinkedListNode(65);
        singlyLinkedListNode.next.next.next.next = new SinglyLinkedListNode(902);

        boolean result = compareLists(singlyLinkedListNode, singlyLinkedListNode);
        System.out.println(result);

        boolean result2 = compareLists(singlyLinkedListNode2, singlyLinkedListNode);
        System.out.println(result2);

        boolean result3 = compareLists(singlyLinkedListNode2, singlyLinkedListNode2);
        System.out.println(result3);


        System.out.println(compareListsUsingRecursion(singlyLinkedListNode, singlyLinkedListNode));

        System.out.println(compareListsUsingRecursion(singlyLinkedListNode2, singlyLinkedListNode));

        System.out.println(compareListsUsingRecursion(singlyLinkedListNode2, singlyLinkedListNode2));

    }


    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode currentHead1 = head1;
        SinglyLinkedListNode currentHead2 = head2;
        while (currentHead1 != null) {
            if (currentHead1.data != currentHead2.data ||
                    currentHead1.next == null ^ currentHead2.next == null)
                return false;
            currentHead2 = currentHead2.next;
            currentHead1 = currentHead1.next;
        }
        return true;
    }

    static boolean compareListsUsingRecursion(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head2 == null ^ head1 == null ||
                head2 != null && head2.data != head1.data)
            return false;
        else {
            if (head1 != null)
                return compareListsUsingRecursion(head1.next, head2.next);
            else
                return true;
        }
    }

}
