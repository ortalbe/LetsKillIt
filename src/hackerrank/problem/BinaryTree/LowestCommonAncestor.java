package hackerrank.problem.BinaryTree;

import java.util.*;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        Node root;
        root = new Node(2);
        Node.insert(root, Node.CHILD_SIDE.Left,1);
        Node.insert(root, Node.CHILD_SIDE.Right,4);
        Node.insert(root.getRight(), Node.CHILD_SIDE.Left,3);
        Node.insert(root.getRight(), Node.CHILD_SIDE.Right,5);
        Node.insert(root.getRight().getRight(), Node.CHILD_SIDE.Right,6);
        Node result =lca(root,3,6);
    }

    public static Node lca(Node root, int v1, int v2) {
     Stack<Node> parentNodeV1 = new Stack<Node>();
     Stack<Node> parentNodeV2 = new Stack<Node>();

     findPath(root,v1,parentNodeV1);
     findPath(root,v2,parentNodeV2);
     Node temp=parentNodeV1.pop();
     while(temp!=null)
     {
         if(parentNodeV2.contains(temp))
             return temp;

         temp=parentNodeV1.pop();
     }

     return null;
    }

    private static void findPath(Node root, int v,  Stack<Node> parentNodeV) {
        parentNodeV.push(root);

        if(root.data==v)
            return;


        if(root.data<v)
            findPath(root.right,v,parentNodeV);
        if(root.data>v)
            findPath(root.left,v,parentNodeV);
    }


}
