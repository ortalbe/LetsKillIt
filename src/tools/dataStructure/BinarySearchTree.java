package tools.dataStructure;

import javax.naming.directory.InvalidAttributeValueException;

public class BinarySearchTree <T extends Comparable<T>> {

    TreeNode<T> root =null;
    int size=0;

    // min and max value in the BST will help us validate BST
    T minValue;
    T maxValue;

    public BinarySearchTree() {

    }
    public BinarySearchTree(TreeNode<T> root) {
        this.root = new TreeNode<T> (root);
    }

    public BinarySearchTree(String key, T rootValue) {
        this.root = new TreeNode<T> (key,rootValue);
    }

    public BinarySearchTree(String key, T rootValue, T minValue,T maxValue) {
        this.root = new TreeNode<T> (key,rootValue);
        this.minValue=minValue;
        this.maxValue=maxValue;
    }

    public int getSize() {
        return size;
    }

    public void inOrderTreeWalk(TreeNode<T> root)
    {
        if(root!=null)
        {
            inOrderTreeWalk(root.getLeftChild());
            System.out.println("Key : " + root.getKey()  + " , Value : " + root.getValue());
            inOrderTreeWalk(root.getRightChild());
        }
    }

    public void preOrderTreeWalk(TreeNode<T> root)
    {
        if(root!=null)
        {
            System.out.println("Key : " + root.getKey()  + " , Value : " + root.getValue());
            preOrderTreeWalk(root.getLeftChild());
            preOrderTreeWalk(root.getRightChild());
        }
    }

    public void postOrderTreeWalk(TreeNode<T> root)
    {
        if(root!=null)
        {
            postOrderTreeWalk(root.getLeftChild());
            postOrderTreeWalk(root.getRightChild());
            System.out.println("Key : " + root.getKey()  + " , Value : " + root.getValue());
        }
    }

    public TreeNode<T>  binarySearch (String key, T value)
    {
       return invokeBinarySearch(root,key, value);

    }

    private TreeNode<T>  invokeBinarySearch(TreeNode<T> root,String key, T value) {
        if(root!=null &&  root.getValue().compareTo(value)==0 && root.getKey().compareTo(key)==0)
            return root;
        else if(root!=null && root.getValue().compareTo(value)>0)
            return invokeBinarySearch(root.getLeftChild(),key,value);
        else if (root!=null &&  root.getValue().compareTo(value)<=0)
            return invokeBinarySearch(root.getRightChild(),key,value);

        return null;
    }

    public  TreeNode<T>  max (TreeNode<T> root)
    {
        TreeNode<T> temp = root;
        while(temp!=null && temp.getRightChild()!=null)
            temp = temp.getRightChild();

        return temp;
    }

    public  TreeNode<T>  min (TreeNode<T>  root)
    {
        TreeNode<T> temp = root;
        while(temp!=null && temp.getLeftChild()!=null)
            temp = temp.getLeftChild();

        return temp;
    }

    public TreeNode<T> treeSuccessor(TreeNode<T> node)
    {
        if(node.getRightChild()!=null)
            return min(node.getRightChild());
        else
        {
            TreeNode<T> parent = node.getParent();
            while (parent.getParent().getRightChild()==parent)
                parent=parent.getParent();

            return parent;
        }

    }

    public boolean treeInsert (String key,T value)
    {
        if(root==null)
            root = new TreeNode<T>(key,value);
        else
        {
            invokedInsert(root,key,value);
        }

        size++;

        return true;
    }

    private void invokedInsert(TreeNode<T> root, String key, T value) {
        if(root==null)
        {
            TreeNode<T> currentNode =  new TreeNode<T>(key, value);
            this.root=currentNode;
        }
        else if(value.compareTo(root.getValue())>=0)
        {
            if(root.getRightChild()!=null)
                invokedInsert(root.getRightChild(),key,value);
            else {
                TreeNode<T> currentNode =  new TreeNode<T>(key, value);
                currentNode.setParent(root);
                root.setRightChild(currentNode);
            }
        }
        else if (value.compareTo(root.getValue())<0)
        {
            if(root.getLeftChild()!=null)
                invokedInsert(root.getLeftChild(),key,value);
            else
            {
                TreeNode<T> currentNode =  new TreeNode<T>(key, value);
                currentNode.setParent(root);
                root.setLeftChild(currentNode);
            }
        }
    }

    public boolean treeDelete (String key,T value)
    {
        if(root==null)
           throw new StackOverflowError("Tree is Empty.");
        else
        {
            invokedDelete(root,key,value);
        }

        size--;

        return true;
    }


    private void invokedDelete(TreeNode<T> root, String key, T value) {
        TreeNode<T> element = binarySearch(key,value);

       if(element==null)
            try {
                throw new InvalidAttributeValueException("element not found key : " + key + " value : " + value);
            } catch (InvalidAttributeValueException e) {
                e.printStackTrace();
            }

        if(element.getRightChild()==null && element.getLeftChild()==null)
        {
            if(element.getParent().getLeftChild()==element)
                element.getParent().setLeftChild(null);
            else
                element.getParent().setRightChild(null);
        }
        else if (element.getRightChild()==null)
        {
            if(element.getParent().getLeftChild()==element) {
                element.getParent().setLeftChild(element.getLeftChild());
                element.getLeftChild().setParent(element.getParent());
            }
            else{
                element.getParent().setRightChild(element.getLeftChild());
                element.getRightChild().setParent(element.getParent());
            }


        }
        else if (element.getLeftChild()==null)
        {
            if(element.getParent().getLeftChild()==element) {
                element.getParent().setLeftChild(element.getLeftChild());
                element.getLeftChild().setParent(element.getParent());
            }
            else {
                element.getParent().setRightChild(element.getRightChild());
                element.getRightChild().setParent(element.getParent());
            }

        }
        else
        {
            TreeNode<T> replaceElement = treeSuccessor(element);
            if(element.getParent().getLeftChild()==element)
                element.getParent().setLeftChild(replaceElement);
            else
                element.getParent().setRightChild(replaceElement);

            if(replaceElement.getParent().getLeftChild()==replaceElement)
                replaceElement.getParent().setLeftChild(null);
            else
                replaceElement.getParent().setRightChild(null);
            replaceElement.setParent(element.getParent());
            replaceElement.setLeftChild(element.getLeftChild());
            replaceElement.setRightChild(element.getRightChild());
        }
    }

    public  int height(TreeNode root) {
        if(root==null || (root.getLeftChild()==null & root.getRightChild()==null))
            return 0;
        return 1+Math.max(height(root.getLeftChild()),height(root.getRightChild()));
    }

    public boolean checkBST(TreeNode root) {

        return validateTree(root,minValue,maxValue);



    }

    public  boolean validateTree(TreeNode root, Comparable<T> min, Comparable<T> max){

        if(root==null)
            return true;
        if(root.getValue().compareTo(min)<=0 || root.getValue().compareTo(max)>=0)
            return false;

        return validateTree(root.getLeftChild(),min,root.getValue())&& validateTree(root.getRightChild(),root.getValue(),max);


    }
}
