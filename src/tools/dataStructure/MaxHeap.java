package tools.dataStructure;

import java.util.ArrayList;
import java.util.List;

import static tools.dataStructure.TreeNode.swap;

public class MaxHeap<T extends Comparable<T>> extends Heap {

    public MaxHeap() {
        nodes = new ArrayList<Node<T>>();

    }

    public MaxHeap(List<String> nodesKeys,List<T> nodesValues ) {
        nodes = new ArrayList<Node<T>>();
        for (int i = 0; i < nodesValues.size(); i++) {
            Node<T> currentNode = new Node<T>(nodesKeys.get(i),nodesValues.get(i));
            nodes.add(currentNode);
        }

        this.size=nodesValues.size();
        this.height=(int) Math.ceil(Math.log(size)/Math.log(2.0));


        for(int i=nodes.size()/2-1;i>0;i--)
            maxHeapify(nodes,i);
    }

    public void maxHeapify(ArrayList<Node<T>> nodes, int i) {
        int largerElementndex=i;
        if( getLeftChildIndex(i)<size-1  && getLeftChild(i)!=null && getLeftChild(i).compareTo(nodes.get(i))>0)
            largerElementndex=getLeftChildIndex(i);
        if( getRightChildIndex(i)<size-1 && getRightChild(i)!=null  && getRightChild(i).compareTo(nodes.get(largerElementndex))>0)
            largerElementndex=getRightChildIndex(i);

        if(largerElementndex!= i)
        {
            swap(nodes,largerElementndex, i);
            maxHeapify(nodes,largerElementndex);
        }

    }

    public T heapMaximum ()
    {
        return ((Node<T>) nodes.get(0)).getValue();
    }

    public Node<T> heapExtractMax ()
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
            maxHeapify(nodes,0);
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
            while(getParent(index)!=null && getParent(index).compareTo(currentNode)<0) {
                swap(nodes,index,getParentIndex(index));
                currentNode = getParent(index);
                index= getParentIndex(index);
            }
        }
        else
        {
            maxHeapInsert(newValue,key);
        }
    }


    public void maxHeapInsert(T newValue, String key)
    {
        Node<T> newNode = new Node<T>(key,newValue);
        nodes.add(newNode);

        this.size=nodes.size();
        this.height=(int) Math.ceil(Math.log(size)/Math.log(2.0));

        heapIncreasedKey(key, newValue);


    }

}
