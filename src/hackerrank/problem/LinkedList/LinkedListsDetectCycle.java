package hackerrank.problem.LinkedList;

import tools.dataStructure.DoublyLinkedListNode;
import tools.dataStructure.SinglyLinkedListNode;

import static tools.dataStructure.DoublyLinkedListNode.sortedInsert;

public class LinkedListsDetectCycle {

    public static void main(String[] args) {

        SinglyLinkedListNode headFirst = new SinglyLinkedListNode(3);
        SinglyLinkedListNode.insert(headFirst,4);
        SinglyLinkedListNode.insert(headFirst,5);
        SinglyLinkedListNode.insert(headFirst,6);
        SinglyLinkedListNode.insert(headFirst,4);
        SinglyLinkedListNode.insert(headFirst,7);

       boolean result = SinglyLinkedListNode.hasCycle(headFirst);
    }
}
