import tools.algorithm.sort.SortMethod;
import tools.arrayUtils.ArrayUtils;
import tools.dataStructure.BinarySearchTree;
import tools.dataStructure.MaxHeap;
import tools.dataStructure.Queue;
import tools.dataStructure.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String []argh)
    {

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>("1",4);
        bst.treeInsert("2",9);
        bst.treeInsert("3",11);
        bst.treeInsert("4",7);
        bst.treeInsert("5",2);
        bst.treeInsert("6",0);
        bst.treeInsert("7",1);
        bst.treeInsert("8",24);
        bst.treeInsert("9",25);
        bst.treeInsert("10",14);
        bst.treeInsert("11",1);
        bst.treeInsert("12",1);
        bst.treeInsert("13",23);
        bst.treeInsert("14",24);
        bst.treeInsert("15",22);
        bst.treeInsert("16",27);
        bst.treeDelete("11",1);
    }
}