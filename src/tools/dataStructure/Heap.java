package tools.dataStructure;

import tools.arrayUtils.ArrayUtils;

import java.util.ArrayList;

public class  Heap <T extends Comparable<T>>{

    protected ArrayList<Node<T>> nodes;
    protected int size;
    protected int height;

    public ArrayList<Node<T>> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node<T>> nodes) {
        this.nodes = nodes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getNode (String key)
    {
        if(nodes!=null )
        {
            for(int i=0;i<nodes.size();i++)
            {
                Node<T> currentNode = nodes.get(i);
                if( currentNode.getKey().compareTo(key)==0) {
                    return currentNode;
                }
            }
        }

        return null;
    }

    public Node<T> getNode (int index)
    {
        if(nodes!=null )
        {
            Node<T> currentNode = nodes.get(index);
            return currentNode;
        }

        return null;
    }

    public int getNodeIndex (String key)
    {
        for(int i=0;i<nodes.size();i++)
        {
            Node<T> currentNode = nodes.get(i);
            if( currentNode.getKey().compareTo(key)==0) {
                return i;
            }
        }

        return -1;
    }


    public Node<T> getLeftChild(int index)
    {
        if (2 * index + 1 < size)
        {
            return  nodes.get((int) Math.floor(2 * index + 1));
        }

        return null;
    }

    public int getLeftChildIndex (int index)
    {
        return (int) Math.floor(Math.floor(2 * index + 1));
    }



    public Node<T> getRightChild(int index)
    {
        if (2 * index + 2 < size)
        {
            return  nodes.get((int) Math.floor(2 * index + 2));
        }

        return null;
    }


    public int getRightChildIndex (int index)
    {
        return (int) Math.floor(Math.floor(2 * index + 2));
    }

    public Node<T> getParent(int index)
    {
        if (index >0)
        {
            return  nodes.get((int) Math.floor((index+1)/2-1));
        }

        return null;
    }

    public int getParentIndex (int index)
    {
        return (int) Math.floor((index+1)/2-1);
    }

    public void printHeap()
    {
        ArrayUtils.printArray(nodes);
    }

    public int findKey (String key)
    {
        for(int i=0;i<nodes.size();i++)
        {
            if(nodes.get(i).getKey().compareTo(key)==0)
                return i;
        }

        return -1;
    }

}
