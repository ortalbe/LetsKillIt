package hackerrank.problem.DictionariesAndHashmaps;

import java.util.*;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, List<Integer>> numberToIndices = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!numberToIndices.containsKey(arr.get(i))) {
                numberToIndices.put(arr.get(i), new ArrayList<>());
            }

            numberToIndices.get(arr.get(i)).add(i);
        }

        long result = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % r != 0) {
                continue;
            }

            long firstNumber = arr.get(i) / r;

            if ((long) arr.get(i) * r > Integer.MAX_VALUE) {
                continue;
            }

            long lastNumber = arr.get(i) * r;

            result += (long) findBeforeCount(numberToIndices, firstNumber, i)
                    * findAfterCount(numberToIndices, lastNumber, i);
        }
        return result;
    }

    static int findBeforeCount(Map<Long, List<Integer>> numberToIndices, long number, int index) {
        if (!numberToIndices.containsKey(number)) {
            return 0;
        }

        List<Integer> indices = numberToIndices.get(number);
        int position = Collections.binarySearch(indices, index);
        if (position < 0) {
            position = -1 - position;
        }

        return position;
    }

    static int findAfterCount(Map<Long, List<Integer>> numberToIndices, long number, int index) {
        if (!numberToIndices.containsKey(number)) {
            return 0;
        }

        List<Integer> indices = numberToIndices.get(number);
        int position = Collections.binarySearch(indices, index);
        if (position < 0) {
            position = -1 - position - 1;
        }

        return indices.size() - 1 - position;
    }


    public static void main(String[] args) {

        List<Long> arr = new ArrayList<Long> ();
        arr.add((long) 1);
        arr.add((long) 1);
        arr.add((long) 1);
        arr.add((long) 1);
        arr.add((long) 1);
        arr.add((long) 1);



        Long a= countTriplets(arr,1);
    }

}
