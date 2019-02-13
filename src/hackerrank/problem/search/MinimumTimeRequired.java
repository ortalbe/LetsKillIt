package hackerrank.problem.search;

import tools.algorithm.sort.SortMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {

        long high = (long) 1000000000;
        long low = (long) 1;
        long result =(long) 0;

        HashMap<Long,Long> machinesMap = new  HashMap <Long,Long>();

        for(int i=0;i<machines.length;i++)
        {
            if(machinesMap.get(machines[i])!=null)
             machinesMap.put(machines[i],machinesMap.get(machines[i])+1);
            else
                machinesMap.put(machines[i], (long) 1);
        }

        while (low <= high) {
            long middle = (low + high) / 2;
            if (calculateItemPerDays(machinesMap, middle) >= goal) {
                result = middle;

                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return result;


    }

    private static Long calculateItemPerDays(HashMap<Long, Long> machinesMap, long days) {

        Long result=(long) 0;

        for(Map.Entry<Long,Long> current:machinesMap.entrySet())
        {
           result=result+days/current.getKey()*current.getValue();
        }

        return result;

    }


    public static void main(String[] args) {

        long [] arr= new long [] {2,3,2};
        System.out.println(minTime(arr,10));
    }

}
