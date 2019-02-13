package hackerrank.problem.LinkedList;

import tools.dataStructure.DoublyLinkedListNode;

import static tools.dataStructure.DoublyLinkedListNode.sortedInsert;

public class ReverseLinkedList {

    public static void main(String[] args) {

        DoublyLinkedListNode head = sortedInsert(null,3);
        head = sortedInsert(head,5);
        head = sortedInsert(head,4);

        DoublyLinkedListNode p =  DoublyLinkedListNode.reverse(head);

    }
}
