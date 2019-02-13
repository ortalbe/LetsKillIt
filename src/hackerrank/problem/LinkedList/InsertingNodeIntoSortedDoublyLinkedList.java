package hackerrank.problem.LinkedList;

import tools.dataStructure.DoublyLinkedListNode;

public class InsertingNodeIntoSortedDoublyLinkedList {

    DoublyLinkedListNode head ;

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {


        return DoublyLinkedListNode.sortedInsert(head,data);

    }

    public static void main(String[] args) {

        DoublyLinkedListNode head = sortedInsert(null,3);
        head = sortedInsert(head,5);
        head = sortedInsert(head,4);

        DoublyLinkedListNode p =  DoublyLinkedListNode.reverse(head);

    }


}
