package hackerrank.problem.BinaryTree;

public class IsThisBinarySearchTree {

    public static void main(String[] args) {

        Node root;
        root = new Node(1);
        Node.insert(root, Node.CHILD_SIDE.Left,2);
        Node.insert(root, Node.CHILD_SIDE.Right,4);
        Node.insert(root.getLeft(), Node.CHILD_SIDE.Left,3);
        Node.insert(root.getLeft(), Node.CHILD_SIDE.Right,5);
        Node.insert(root.getRight(), Node.CHILD_SIDE.Left,6);
        Node.insert(root.getRight(), Node.CHILD_SIDE.Right,7);

        boolean result =checkBST(root);
    }

    public static boolean checkBST(Node root) {

        return checkTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);



    }

    public static boolean checkTree(Node root,int min,int max){

        if(root==null)
            return true;
        if(root.data<=min || root.data>=max)
            return false;

        return checkTree(root.left,min,root.data)& checkTree(root.right,root.data,max);


    }
}
