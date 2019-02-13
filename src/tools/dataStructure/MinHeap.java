package tools.dataStructure;

import java.util.ArrayList;
import java.util.List;

import static tools.dataStructure.TreeNode.swap;

public class MinHeap<T extends Comparable<T>> extends Heap {

    public MinHeap() {
        nodes = new ArrayList<Node<T>>();

    }

    public MinHeap(List<String> nodesKeys, List<T> nodesValues ) {
        nodes = new ArrayList<Node<T>>();
        for (int i = 0; i < nodesValues.size(); i++) {
            Node<T> currentNode = new Node<T>(nodesKeys.get(i),nodesValues.get(i));
            nodes.add(currentNode);
        }

        this.size=nodesValues.size();
        this.height=(int) Math.ceil(Math.log(size)/Math.log(2.0));


        for(int i=nodes.size()/2-1;i>0;i--)
            minHeapify(nodes,i);
    }

    public void minHeapify(ArrayList<Node<T>> nodes, int i) {
        int smallestElementndex=i;
        if(getLeftChild(i)!=null && getLeftChildIndex(i)<size && getLeftChild(i).compareTo(nodes.get(i))<0)
            smallestElementndex=getLeftChildIndex(i);
        if(getRightChild(i)!=null && getRightChildIndex(i)<size && getRightChild(i).compareTo(nodes.get(smallestElementndex))<0)
            smallestElementndex=getRightChildIndex(i);

        if(smallestElementndex!= i)
        {
            swap(nodes,smallestElementndex, i);
            minHeapify(nodes,smallestElementndex);
        }

    }

    public T heapMinimum ()
    {
        return ((Node<T>) nodes.get(0)).getValue();
    }

    public Node<T> heapExtractMin ()
    {
        Node<T> max=null;
        if(nodes.size()>0)
            max = new Node<T>((Node<T>) nodes.get(0));
        else
            throw new IndexOutOfBoundsException("the heap is empty");
        if(nodes.size()>1)
        {
            ((Node<T>) nodes.get(0)).setValue(((Node<T>) nodes.get(nodes.size()-1)).getValue());
            ((Node<T>) nodes.get(0)).setKey(((Node<T>) nodes.get(nodes.size()-1)).getKey());
            nodes.remove(nodes.size()-1);
            minHeapify(nodes,0);
            this.size=nodes.size();
            this.height=(int) Math.ceil(Math.log(size)/Math.log(2.0));
        }
        return max;
    }


    public void heapIncreasedKey (String key, T newValue)
    {
        int index = getNodeIndex(key);
        if(index!=-1)
        {
            Node<T> currentNode = (Node<T>) nodes.get(index);
            currentNode.setValue(newValue);
            while(getParent(index)!=null && getParent(index).compareTo(currentNode)>0) {
                swap(nodes,index,getParentIndex(index));
                currentNode = getParent(index);
                index= getParentIndex(index);
            }
        }
        else
        {
            minHeapInsert(newValue,key);
        }
    }


    public void minHeapInsert(T newValue, String key)
    {
        Node<T> newNode = new Node<T>(key,newValue);
        nodes.add(newNode);

        this.size=nodes.size();
        this.height=(int) Math.ceil(Math.log(size)/Math.log(2.0));

        heapIncreasedKey(key, newValue);


    }

}
