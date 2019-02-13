package hackerrank.problem.LinkedList;

import tools.dataStructure.SinglyLinkedListNode;

public class InsertNodeSpecificPositionLinkedList {

    public static void main(String[] args) {

        SinglyLinkedListNode headFirst = new SinglyLinkedListNode(3);
        SinglyLinkedListNode.insert(headFirst,4);
        SinglyLinkedListNode.insert(headFirst,5);
        SinglyLinkedListNode.insert(headFirst,6);
        SinglyLinkedListNode.insert(headFirst,4);
        SinglyLinkedListNode.insert(headFirst,7);
        SinglyLinkedListNode.insertNodeAtPosition(headFirst,8,3);

    }
}
