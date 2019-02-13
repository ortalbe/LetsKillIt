package tools.arrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    public static <T> void printArray(T[] arr)
    {
        if(arr.length>0) {
            System.out.print(arr[0]);
            for (int i = 1; i < arr.length; i++)
                System.out.print(", " + arr[i]);
        }
        else
            System.out.println("Array is Empty");
        System.out.println();

    }

    public static <T> void printArray(List<T> arr)
    {
        System.out.println();
        if(arr.size()>0) {
            System.out.print(arr.get(0));
            for (int i = 1; i < arr.size(); i++)
                System.out.print(", " + arr.get(i));
        }
        else
            System.out.println("Array is Empty");

        System.out.println();

    }

    public static <T>  void swap (T[] arr, int desIndex, int sourceIndex)
    {
        T temp;
        temp = arr[sourceIndex];
        arr[sourceIndex]=arr[desIndex];
        arr[desIndex]=temp;
    }

    public static <T>  void swap (ArrayList<T> arr, T des, T source)
    {

        int sourceIndex = arr.indexOf(source);
        int desIndexIndex = arr.indexOf(des);

        arr.set(sourceIndex,des);
        arr.set(desIndexIndex,source);
    }

    public static <T> T[] toArray(ArrayList<T> arrayList)
    {
        T[] arr = (T[])new Object[arrayList.size()];
        for(int i=0;i<arrayList.size();i++)
            arr[i]=arrayList.get(i);
        return arr;
    }


    public static  Integer[] toArrayInteger(ArrayList<Integer> arrayList)
    {
        Integer[] arr = new Integer[arrayList.size()];
        for(int i=0;i<arrayList.size();i++)
            arr[i]=arrayList.get(i);
        return arr;
    }

    public static <T> ArrayList<T>  toArrayList(T [] array)
    {
        ArrayList<T>  temp = new ArrayList<T> ();

        for(int i=0;i<array.length;i++)
        {
            temp.add(array[i]);
        }

        return temp;
    }
}
