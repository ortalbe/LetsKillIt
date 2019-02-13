package tools.dataStructure;

import java.util.ArrayList;

public class TreeNode<T extends Comparable<T>> {

    Node<T> keyValue;
    TreeNode<T> parent;
    TreeNode<T>  leftChild;
    TreeNode<T> rightChild;

    public TreeNode(String key, T value) {
        this.keyValue = new Node(key,value);

        this.parent=null;
        this.leftChild=null;
        this.rightChild=null;
    }



    public TreeNode(Node<T> keyValue) {
        this.keyValue = keyValue;
    }

    public TreeNode(T value, String key , TreeNode<T> parent, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.keyValue = new Node(key,value);

        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;

    }

    public TreeNode(TreeNode<T> node) {
        this.keyValue = new Node(node.getKey(),node.getValue());

        this.parent = node.getParent();
        this.leftChild = node.getLeftChild();
        this.rightChild = node.getRightChild();

    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public ArrayList<TreeNode<T>> getChildren() {
        ArrayList<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
        children.add(leftChild);
        children.add(rightChild);
        return children;
    }

    public T getValue() {
        return keyValue.getValue();
    }

    public void setValue(T value) {
        this.keyValue.setValue(value);
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public String getKey() {
        return this.keyValue.getKey();
    }

    public void setKey(String key) {
        this.keyValue.setKey(key);
    }

    public Node<T> getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(Node<T> keyValue) {
        this.keyValue = keyValue;
    }

    @Override
    public String toString() {
        String str = "Node : ";
        if(keyValue.getValue()!=null)
            str = str + keyValue.getValue();
        else
            str = str + "NA";

        str = str + "\n Key : ";
        if(keyValue.getKey()!=null)
            str = str + keyValue.getKey();
        else
            str = str + "NA";

        str = str + "\n Parent : ";
        if(parent!=null)
            str = str + parent.getValue();
        else
            str = str + "NA";

        str = str +"\n Left Child : ";
        if(leftChild!=null)
            str = str + leftChild.getValue();
        else
            str = str + "NA";

        str = str +"\n Right Child : ";
        if(rightChild!=null)
            str = str + rightChild.getValue();
        else
            str = str + "NA";

        str = str +"\n";
        return str;

    }

    public int compareTo(TreeNode<T> o)
    {
        if(o==this)
            return 0;
        else
            return this.compareTo(o);
    }

    public static <T extends Comparable<T>> void swap (ArrayList<Node<T>> arr,int desIndex, int sourceIndex)
    {

        T tempValue = arr.get(sourceIndex).getValue();
        String tempKey = arr.get(sourceIndex).getKey();

        arr.get(sourceIndex).setValue(arr.get(desIndex).getValue());
        arr.get(sourceIndex).setKey(arr.get(desIndex).getKey());
        arr.get(desIndex).setValue(tempValue);
        arr.get(desIndex).setKey(tempKey);


    }

    private static <T extends Comparable<T>> void fixChildren(ArrayList<TreeNode<T>> arr, int index) {
        if(2 * index+1<arr.size())
            arr.get(index).getLeftChild().setValue(arr.get(2 * index+1).getValue());
        else
            arr.get(index).setLeftChild(null);

        if(2 * index+2<arr.size())
            arr.get(index).getRightChild().setValue(arr.get(2 * index+2).getValue());
        else
            arr.get(index).setRightChild(null);

        if(index>=1)
            arr.get(index).getParent().setValue(arr.get((index-1) / 2).getValue());
        else
            arr.get(index).setParent(null);

    }


}
