package hackerrank.problem.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {

        int [] sortedArrayA= binarySort(a);
        int [] sortedArrayB= binarySort(b);
        int [] sortedArrayC= binarySort(c);

        int [] sortedRemoveDupA= removeDuplication(sortedArrayA);
        int [] sortedRemoveDupB= removeDuplication(sortedArrayB);
        int [] sortedRemoveDupC= removeDuplication(sortedArrayC);
        long numberOfTriplets =0;
        int smallerElementA=0;
        int smallerElementC=0;

        for(int i=0;i<sortedRemoveDupB.length;i++)
        {
            if(i>1 && sortedRemoveDupB[i]==sortedRemoveDupB[i-1])
                continue;
            smallerElementA = binarySrearch(sortedRemoveDupA, sortedRemoveDupB[i]);
            smallerElementC = binarySrearch(sortedRemoveDupC, sortedRemoveDupB[i]);

            while(smallerElementA<sortedRemoveDupA.length && sortedRemoveDupA[smallerElementA]<=sortedRemoveDupB[i])
                smallerElementA++;

            while(smallerElementC<sortedRemoveDupC.length && sortedRemoveDupC[smallerElementC]<=sortedRemoveDupB[i])
                smallerElementC++;

            numberOfTriplets=numberOfTriplets+smallerElementA*smallerElementC;
        }

        return numberOfTriplets;
    }

    private static int[] removeDuplication(int[] sortedArrayA) {
        ArrayList<Integer> arr = new ArrayList<>();


        for(int i=0;i<sortedArrayA.length;i++) {
            if (i != 0 && sortedArrayA[i - 1] != sortedArrayA[i])
                arr.add(sortedArrayA[i]);
            if (i == 0)
                arr.add(sortedArrayA[i]);
        }

       int [] result = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            result[i]=arr.get(i);
            return result;

    }

    public static  int binarySrearch (int [] arr, int value) {
        int result =callBinarySearch(arr,value,0,arr.length-1);

        return result;
    }

    private static  int callBinarySearch(int[] arr, int value, int firstIndex, int lastIndex) {

        if (lastIndex > firstIndex) {
            int middle = firstIndex+(lastIndex - firstIndex) / 2;
            if (arr[middle]==value) {
                return middle;
            } else {
                if (arr[middle]>=value)
                    return callBinarySearch(arr, value, firstIndex, middle);
                else
                    return callBinarySearch(arr, value,middle + 1, lastIndex);
            }
        }

        return firstIndex;
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

    public static void main(String[] args) throws FileNotFoundException {

        File in = new File("input.txt");
        Scanner scanner = new Scanner(in);

        String[] nd = scanner.nextLine().split(" ");

        int sizeFirstArray = Integer.parseInt(nd[0]);

        int sizeSecondArray = Integer.parseInt(nd[1]);

        int sizeThirdArray = Integer.parseInt(nd[2]);

        int [] arrA = new int [sizeFirstArray];
        int [] arrB = new int [sizeSecondArray];
        int [] arrC = new int [sizeThirdArray];

        String expenditureItemsString = scanner.nextLine();
        Pattern SPACE = Pattern.compile(" ");
        String[] expenditureItemsArrA = SPACE.split(expenditureItemsString);

        for (int i = 0; i < sizeFirstArray; i++) {
            int expenditureItem = Integer.parseInt(expenditureItemsArrA[i]);
            arrA[i] = expenditureItem;
        }

        expenditureItemsString = scanner.nextLine();
        String[] expenditureItemsArrB = SPACE.split(expenditureItemsString);

        for (int i = 0; i < sizeSecondArray; i++) {
            int expenditureItem = Integer.parseInt(expenditureItemsArrB[i]);
            arrB[i] = expenditureItem;
        }

        expenditureItemsString = scanner.nextLine();
        String[] expenditureItemsArrC = SPACE.split(expenditureItemsString);
        for (int i = 0; i < sizeThirdArray; i++) {
            int expenditureItem = Integer.parseInt(expenditureItemsArrC[i]);
            arrC[i] = expenditureItem;
        }

        scanner.close();

        System.out.println(triplets(arrA,arrB,arrC));
    }
}
