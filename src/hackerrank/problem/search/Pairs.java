package hackerrank.problem.search;

import java.util.Arrays;

public class Pairs {

    static int pairs(int k, int[] arr) {

        int [] sortedArray = new int [arr.length];
        sortedArray=binarySort(arr);
        int firstValue=0;
        int runningIndex=0;
        int numberOfPairs=0;

        for(int i=0;i<sortedArray.length;i++)
        {
            firstValue=sortedArray[i];
            runningIndex=i+1;
            while(runningIndex<sortedArray.length && firstValue+k>=sortedArray[runningIndex] )
            {
                if(firstValue+k==sortedArray[runningIndex])
                    numberOfPairs++;
                runningIndex++;
            }
        }

        return numberOfPairs;

    }

    public static int[] binarySort(int[] arr )
    {
        int size =arr.length;
        int[] result;
        result = Arrays.copyOf(arr,size);

        callMergeSort(result,0,size-1);

        return result;
    }

    private static   void callMergeSort(int[] result, int firstIndex, int lastIndex) {

        if(lastIndex > firstIndex )
        {
            int splitIndex=0;
            splitIndex =(firstIndex+lastIndex)/2;

            callMergeSort(result,firstIndex,splitIndex);
            callMergeSort(result,splitIndex+1,lastIndex);
            merge(result,firstIndex,lastIndex,splitIndex);
        }


    }

    private static   void merge(int[] result, int firstIndex, int lastIndex, int splitIndex) {

        int[] tempArray  = Arrays.copyOfRange(result,firstIndex,lastIndex+1);
        int[] tempArrayLeft  = Arrays.copyOfRange(result,firstIndex,splitIndex+1);
        int[] tempArrayRight  = Arrays.copyOfRange(result,splitIndex+1,lastIndex+1);
        int j=0;
        int counter=0;
        for(int i=0;i<tempArrayLeft.length;i++) {
            if (j<tempArrayRight.length && tempArrayLeft[i]>(tempArrayRight[j]))
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

    public static void main(String[] args) {

        int [] arr= new int [] {1 ,3 ,5 ,8 ,6 ,4 ,2};
        pairs(2,arr);
    }


}
