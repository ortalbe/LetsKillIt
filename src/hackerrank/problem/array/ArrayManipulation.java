package hackerrank.problem.array;

import javafx.util.Pair;

import java.util.HashMap;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {

        long maxValue = -0;
        validateQueries(queries);
        long[] arr = new long[n];
        int a, b, k;

        for (int i = 0; i < queries.length ; i++) {
            a = queries[i][0];
            b = queries[i][1];
            k = queries[i][2];

            arr[a-1] = arr[a-1] + k;
            if(b<=n-1)
                arr[b] = arr[b] - k;
        }


        for(int i=1;i<n;i++)
        {
            arr[i]=arr[i]+arr[i-1];
            if(arr[i]>maxValue)
                maxValue=arr[i];
        }

        return maxValue;
    }

    private static void validateQueries(int[][] queries) {
        for (int i = 0; i < queries.length / 3; i++) {
            if (queries[i][0] > queries[i][1])
                throw new IllegalArgumentException();

        }


    }
}