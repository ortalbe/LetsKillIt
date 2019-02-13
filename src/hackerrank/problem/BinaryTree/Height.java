package hackerrank.problem.BinaryTree;

import tools.dataStructure.BinarySearchTree;

public class Height {



    public static void main(String[] args) {

        Node root;
        root = new Node(3);
        Node.insert(root, Node.CHILD_SIDE.Left,5);
        Node.insert(root, Node.CHILD_SIDE.Right,7);
        Node.insert(root.getLeft(), Node.CHILD_SIDE.Left,4);
        Node.insert(root.getLeft(), Node.CHILD_SIDE.Right,2);
        Node.insert(root.getLeft().getRight(), Node.CHILD_SIDE.Left,1);
        Node.insert(root.getLeft().getRight().getLeft(), Node.CHILD_SIDE.Right,5);
        Node.insert(root.getRight(), Node.CHILD_SIDE.Left,6);
        Node.insert(root.getRight(), Node.CHILD_SIDE.Right,8);

        int height=Node.height(root);
    }

}
