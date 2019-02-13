package hackerrank.problem.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CountingInversions {

    private static long numberOfInversion=0;
    static long countInversions(int[] arr) {

         callMergeSort(arr,0,arr.length-1);
         return numberOfInversion;
    }

    private static  void callMergeSort(int[] result, int firstIndex, int lastIndex) {

        if(lastIndex > firstIndex )
        {
            int splitIndex=0;
            splitIndex =(firstIndex+lastIndex)/2;

           callMergeSort(result,firstIndex,splitIndex);
           callMergeSort(result,splitIndex+1,lastIndex);
           merge(result,firstIndex,lastIndex,splitIndex);
        }

    }

    private static void merge(int[] result, int firstIndex, int lastIndex, int splitIndex) {

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
                numberOfInversion=numberOfInversion+tempArrayLeft.length-i;
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();*/

       int [] arr = {7,5,3,1};
       long result = countInversions(arr);
    }
}
