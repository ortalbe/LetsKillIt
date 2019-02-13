package hackerrank.problem.sorting;

import tools.algorithm.sort.SortMethod;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarkAndToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int [] sortPrices = new int[prices.length];
        int numberOfToys = 0;
        sortPrices = SortMethod.countSort(prices);

        int index =0;
        while(k-sortPrices[index]>0 )
        {
            k=k-sortPrices[index];
            numberOfToys++;
            index++;
        }

        return numberOfToys;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int [] prices = {1 ,12, 5 ,111, 200, 1000, 10};
        int k = 50;
        int result = maximumToys(prices, k);

      System.out.print(result);
    }
}
