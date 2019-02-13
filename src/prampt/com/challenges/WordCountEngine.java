package prampt.com.challenges;

import tools.dataStructure.MaxHeap;
import tools.dataStructure.Node;
import tools.dataStructure.TreeNode;

public class WordCountEngine {


    static String[][] wordCountEngine(String document) {
        String [] words = document.split(" ");
        String [][] result = null;
        String temp;
        MaxHeap<Integer> heap = new MaxHeap<Integer>();
        for(int i=0;i<words.length;i++)
        {
            temp=words[i];
            temp = temp.toLowerCase();
            temp = temp.replaceAll("\\p{Punct}", "");
            Node<Integer> node = heap.getNode(temp);
            if(node!=null)
            {
                Integer value = (Integer) node.getValue()+1;
                heap.heapIncreasedKey(temp,value);
            }
            else
            {
                heap.maxHeapInsert(1,temp);
            }

        }

        result = new String [heap.getSize()][2];

        int size = heap.getSize();
        for(int i=0;i<size;i++) {
            Node<Integer> max = heap.heapExtractMax();
            result[i][0] = max.getKey();
            result[i][1] = max.getValue().toString();
        }

        return result;
    }

    public static void main(String[] args) {

        String [] []  result = wordCountEngine(args[0]);
        System.out.print("[ ");
        for(int i=0;i<result.length;i++)
        {
            System.out.print(" ['" + result[i][0] + "', " +  result[i][1] + "],");
        }
    }

}
