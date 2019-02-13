package tools.algorithm.search;

public class SearchMethod {

    public static <T extends Comparable<T>> int linearSrearch (T [] arr, T value)
    {
        int result =-1;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].compareTo(value)==0)
                result = i;
        }

        return result;
    }

    public static <T extends Comparable<T>> int binarySrearch (T [] arr, T value) {
        int result =callBinarySearch(arr,value,0,arr.length-1);

        return result;
    }

    private static <T extends Comparable<T>> int callBinarySearch(T[] arr, T value, int firstIndex, int lastIndex) {

        if (lastIndex > firstIndex) {
            int middle = firstIndex+(lastIndex - firstIndex) / 2;
            if (arr[middle].compareTo(value)==0) {
                return middle;
            } else {
                if (arr[middle].compareTo(value) > 0)
                    return callBinarySearch(arr, value, firstIndex, middle);
                else
                    return callBinarySearch(arr, value,middle + 1, lastIndex);
            }
        }

        return -1;
    }



}
