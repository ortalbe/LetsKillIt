package hackerrank.problem.sorting;

import java.util.Arrays;

import static tools.arrayUtils.ArrayUtils.swap;

public class BubbleSort {

    public static void printSortStatus (int [] arr, long numberOfSwap)
    {
        System.out.println("Array is sorted in " +numberOfSwap +  " swaps.");
        System.out.println("First Element: " +arr[0]);
        System.out.println("Last Element: " +arr[arr.length-1]);

    }
    public static  long bubbleSort( int[] arr )
    {
        int size =arr.length;
        long swapCount = 0;

        for(int i=0;i<size;i++)
            for(int j=1;j<=size-(i+1);j++)
                if(arr[j]<arr[j-1]) {
                    swap(arr, j - 1, j);
                    swapCount++;
                }


        return swapCount;
    }

    static void countSwaps(int[] a) {
        long swapCount = bubbleSort(a);
        printSortStatus(a,swapCount);

    }

    public static  void swap (int[] arr, int desIndex, int sourceIndex)
    {
        int temp;
        temp = arr[sourceIndex];
        arr[sourceIndex]=arr[desIndex];
        arr[desIndex]=temp;
    }

    public static void main(String[] args) {

        int [] arr = {3,2,1};
        countSwaps(arr);
    }

}
