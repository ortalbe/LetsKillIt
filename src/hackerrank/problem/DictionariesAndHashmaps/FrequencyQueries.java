package hackerrank.problem.DictionariesAndHashmaps;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]>  queries) {

        HashMap<Integer,Integer> mapData = new HashMap<Integer,Integer>();
        HashMap<Integer,List<Integer>> mapOccurence = new HashMap<Integer,List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for(int index = 0 ; index<queries.size() ; index++)
        {
            int []  currentQuery = queries.get(index);
            Integer data = currentQuery[1];
            switch (currentQuery[0])
            {
                case 1:
                    insertData(mapData,mapOccurence, data);
                    break;
                case 2:
                    deleteData(mapData,mapOccurence, data);
                    break;
                case 3:
                    printOccurence(mapOccurence,data,output);
                    break;
            }
        }


    return output;
    }

    private static void printOccurence(HashMap<Integer, List<Integer>> mapOccurence, Integer data,List<Integer> output) {

        if(mapOccurence.get(data)==null)
            output.add(0);
        else if(mapOccurence.get(data).isEmpty())
            output.add(0);
        else
            output.add(1);
    }

    private static void deleteData(HashMap<Integer, Integer> mapData, HashMap<Integer, List<Integer>> mapOccurence, Integer data) {
        if(mapData.get(data)!=null)
        {
            Integer occurence = mapData.get(data);
            List<Integer> list =mapOccurence.get(occurence);
            list.remove(data);
            if(occurence>1) {
                mapData.put(data, occurence - 1);
                list = mapOccurence.get(occurence-1);
                list.add(data);
                mapOccurence.put(occurence-1,list);
            }
            else
            {
                mapData.remove(data);
                mapOccurence.put(occurence, list);
            }


        }
    }

    private static void insertData(HashMap<Integer, Integer> mapData,HashMap<Integer, List<Integer>> mapOccurence, Integer data) {
        if(mapData.get(data)!=null)
        {
            Integer occurence = mapData.get(data);
            mapData.put(data,occurence+1);
            List<Integer> list = mapOccurence.get(occurence+1);
            if(list ==null)
                list = new  ArrayList<Integer>();
            list.add(data);
            mapOccurence.put(occurence+1,list);
            list = mapOccurence.get(occurence);
            if(list!=null)
                list.remove(data);
        }
        else
        {
            mapData.put(data,1);
            List<Integer> list = mapOccurence.get(1);
            if(list==null)
            {
                list = new ArrayList<Integer> ();
                list.add(data);
            }
            else
                list.add(data);
            mapOccurence.put(1,list);
        }

    }

    public static void main(String[] args) {

       ArrayList<int[]>  queries  = new ArrayList<int[]>();

        queries.add(new int []{1,5});
        queries.add(new int []{1,6});
        queries.add(new int []{3,2});
        queries.add(new int []{1,10});
        queries.add(new int []{1,10});
        queries.add(new int []{1,6});
        queries.add(new int []{2,5});
        queries.add(new int []{3,2});

        List<Integer> result = freqQuery(queries);

    }
}
