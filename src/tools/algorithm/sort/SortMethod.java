package tools.algorithm.sort;

import tools.arrayUtils.ArrayUtils;
import tools.dataStructure.MaxHeap;
import tools.dataStructure.TreeNode;
import java.util.*;
import static tools.arrayUtils.ArrayUtils.swap;

public class SortMethod {

    public static <T extends Comparable<T>> T[] bubbleSort( T[] arr )
    {
        int size =arr.length;
        T[] result;
        result = Arrays.copyOf(arr,size);

        for(int i=0;i<size;i++)
            for(int j=1;j<=size-(i+1);j++)
               if(result[j].compareTo(result[j-1])<0)
                   swap(result,j-1,j);

        return result;
    }


    public static <T extends Comparable<T>> T[] optimizedBubbleSort( T[] arr )
    {
        int size =arr.length;
        T[] result;
        result = Arrays.copyOf(arr,size);

        for(int i=0;i<size;i++)
        {
            boolean swapped = false;
            for(int j=1;j<=size-(i+1);j++) {

                if (result[j].compareTo(result[j - 1]) < 0) {
                    swap(result, j - 1, j);
                    swapped=true;
                }
            }

            if(!swapped)
            {
                System.out.println("index = " + i);
                break;
            }

        }

        return result;
    }

    public static <T extends Comparable<T>> T[] naiveSort(T[] arr )
    {
        int size =arr.length;
        T[] result;
        result = Arrays.copyOf(arr,size);

        for(int i=0;i<size;i++)
            for(int j=1;j<=size-(i+1);j++)
                if(result[j].compareTo(result[i])<0)
                    swap(result,j-1,j);

        return result;
    }


    public static <T extends Comparable<T>> T[] binarySort(T[] arr )
    {
        int size =arr.length;
        T[] result;
        result = Arrays.copyOf(arr,size);

        callMergeSort(result,0,size-1);

        return result;
    }

    private static  <T extends Comparable<T>> void callMergeSort(T[] result, int firstIndex, int lastIndex) {

       if(lastIndex > firstIndex )
        {
            int splitIndex=0;
            splitIndex =(firstIndex+lastIndex)/2;

            callMergeSort(result,firstIndex,splitIndex);
            callMergeSort(result,splitIndex+1,lastIndex);
            merge(result,firstIndex,lastIndex,splitIndex);
        }


    }

    private static  <T extends Comparable<T>>  void merge(T[] result, int firstIndex, int lastIndex, int splitIndex) {

        T[] tempArray  = Arrays.copyOfRange(result,firstIndex,lastIndex+1);
        T[] tempArrayLeft  = Arrays.copyOfRange(result,firstIndex,splitIndex+1);
        T[] tempArrayRight  = Arrays.copyOfRange(result,splitIndex+1,lastIndex+1);
        int j=0;
        int counter=0;
        for(int i=0;i<tempArrayLeft.length;i++) {
            if (j<tempArrayRight.length && tempArrayLeft[i].compareTo(tempArrayRight[j]) > 0)
            {
                tempArray[counter]=tempArrayRight[j];
                j++;
                counter++;
                i--;
            }
            else
            {
                tempArray[counter]=tempArrayLeft[i];
                counter++;
            }


        }
        while (j<tempArrayRight.length)
        {
            tempArray[counter]=tempArrayRight[j];
            counter++;
            j++;
        }

        for(int i=0;i<=tempArray.length-1;i++)
            result[firstIndex+i]=tempArray[i];
    }



    public static <T extends Comparable<T>> T[]  inserionSort (T[] arr )
    {
        T[] result = Arrays.copyOf(arr,arr.length);
        for (int i=1;i<arr.length;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(result[j+1].compareTo(result[j])<0)
                    swap(result,j+1,j);
                else
                    break;
            }
        }

        return result;
    }

    public static <T extends Comparable<T>> ArrayList<T>  inserionSort (ArrayList<T>  arr )
    {
        ArrayList<T> result = new ArrayList<T>(arr);
        for (int i=1;i<arr.size();i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(result.get(j+1).compareTo(result.get(j))<0)
                    swap(result,result.get(j+1),result.get(j));
                else
                    break;
            }
        }

        return result;
    }


    public static <T extends Comparable<T>> T[]  quickSort (T[] arr  ) {
       T[] tempArray =  Arrays.copyOf(arr,arr.length);

       callQuickSort(tempArray,0,tempArray.length-1);

       return tempArray;
    }

    private static <T extends Comparable<T>> void  callQuickSort (T[] arr , int firstIndex, int lastIndex ) {
        if(lastIndex>firstIndex) {
            Random rand = new Random();
            int index = firstIndex + rand.nextInt(lastIndex-firstIndex);
            T pivotValue = arr[index];
            swap(arr,lastIndex,index);
            int pivotIndex = partition(arr, firstIndex, lastIndex, pivotValue);
            swap(arr,pivotIndex,lastIndex);
            callQuickSort(arr, firstIndex, pivotIndex-1);
            callQuickSort(arr, pivotIndex + 1, lastIndex);
        }
    }

    private static <T extends Comparable<T>> int partition (T[] arr , int firstIndex, int lastIndex, T pivot )
    {
        int pivotIndex=firstIndex;

        for(int i=firstIndex;i<lastIndex;i++)
            if(arr[i].compareTo(pivot)<0) {
                swap(arr,pivotIndex,i);
                pivotIndex++;
            }

            return pivotIndex;
    }

    public static <T extends Comparable<T>> void heapSort(MaxHeap<T> heap)
    {
        int currentIndexToSwap = heap.getSize()-1;
        int originalSize = heap.getSize();
        for (int i=0;i<originalSize;i++)
        {
            TreeNode.swap(heap.getNodes(),0,currentIndexToSwap--);
            heap.setSize(currentIndexToSwap+1);
            heap.maxHeapify(heap.getNodes(),0);
        }
        heap.setSize(heap.getNodes().size());
    }

    public static int[] countSort(int[] arr)
    {
        int max = 0;

        int [] result = new int[arr.length];

        for(int i=0;i<arr.length;i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int[] c = new int[max];
        for(int i=0;i<arr.length;i++)
            c[arr[i]-1] =  c[arr[i]-1] +1;

        int temp=0;
        for (int i=0 ;i<c.length;i++)
        {
            temp = temp + c[i];
            c[i]=temp;
        }

        for(int i=result.length-1;i>=0;i--)
        {
            result[c[arr[i]-1]-1] = arr[i];
            c[arr[i]-1]= c[arr[i]-1]-1;
        }

        return result;

    }

    public static Integer[] countSort(Integer[] arr)
    {
        Integer max = 0;

        Integer [] result = new Integer[arr.length];

        for(int i=0;i<arr.length;i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        Integer[] c = new Integer[max];

        for (int i=0;i<max;i++)
            c[i] = 0;

        for(int i=0;i<arr.length;i++)
            c[arr[i]-1] =  c[arr[i]-1] +1;

        int temp=0;
        for (int i=0 ;i<c.length;i++)
        {
            temp = temp + c[i];
            c[i]=temp;
        }

        for(int i=result.length-1;i>=0;i--)
        {
            result[c[arr[i]-1]-1] = arr[i];
            c[arr[i]-1]= c[arr[i]-1]-1;
        }

        return result;

    }

    public static Integer[] bucketSort ( int[] arr)
    {

        ArrayList<Integer> returnArr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>> ();

        int max = arr[0];
        int min = arr[0];

        for(int i=0;i<arr.length;i++) {
            if (max < arr[i])
                max = arr[i];
            if (min > arr[i])
                min = arr[i];

            map.add(new ArrayList<Integer>());
        }



        for(int i=0;i<arr.length;i++) {
            map.get((int) (((float) arr[i]/(max-min))*arr.length-1)).add(arr[i]);
        }

        for(int i=0;i<arr.length;i++) {
            returnArr.addAll(inserionSort(map.get(i)));

        }


        return ArrayUtils.toArrayInteger(returnArr);
    }
}
