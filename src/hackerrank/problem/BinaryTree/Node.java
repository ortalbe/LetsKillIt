package hackerrank.problem.BinaryTree;

public class Node implements Comparable {

    int data;
    Node left;
    Node right;

    @Override
    public int compareTo(Object o) {
        Node temp = (Node) o;
        return data-temp.data;
    }

    public enum CHILD_SIDE {Left,Right;};
    public Node(int data) {
        this.data = data;
    }

   public static int height(Node root) {
        if(root==null || (root.left==null & root.right==null))
            return 0;
       return 1+Math.max(height(root.left),height(root.right));
    }

    public static boolean insert(Node parent, CHILD_SIDE side,int data) {
        if(parent==null)
            return false;
        if(side==CHILD_SIDE.Left)
        {
            if(parent.getLeft()!=null)
                return false;
            else
                parent.setLeft(new Node(data));
        }
        if(side==CHILD_SIDE.Right)
        {
            if(parent.getRight()!=null)
                return false;
            else
                parent.setRight(new Node(data));
        }

        return true;

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
