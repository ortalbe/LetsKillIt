package hackerrank.problem.LinkedList;

import tools.dataStructure.DoublyLinkedListNode;
import tools.dataStructure.SinglyLinkedListNode;

import static tools.dataStructure.DoublyLinkedListNode.sortedInsert;

public class FindMergePointofTwoLists {


    public static void main(String[] args) {

        SinglyLinkedListNode headFirst = new SinglyLinkedListNode(3);
        SinglyLinkedListNode.insert(headFirst,4);
        SinglyLinkedListNode.insert(headFirst,5);
        SinglyLinkedListNode.insert(headFirst,8);
        SinglyLinkedListNode.insert(headFirst,6);
        SinglyLinkedListNode.insert(headFirst,5);

        SinglyLinkedListNode headSecond = new SinglyLinkedListNode(1);
        SinglyLinkedListNode.insert(headSecond,2);
        SinglyLinkedListNode.insert(headSecond,8);
        SinglyLinkedListNode.insert(headSecond,6);
        SinglyLinkedListNode.insert(headSecond,5);

        SinglyLinkedListNode.findMergeNode(headFirst,headSecond);

    }
}
