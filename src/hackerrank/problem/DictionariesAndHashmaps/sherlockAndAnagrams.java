package hackerrank.problem.DictionariesAndHashmaps;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sherlockAndAnagrams {


    static int sherlockAndAnagrams(String s) {

        HashMap<String, ArrayList<Pair<Integer, Integer>>> map = new HashMap<String, ArrayList<Pair<Integer, Integer>>>();
        HashMap<String, Pair<String, String>> result = new HashMap<String, Pair<String, String>>();
        int counter =0;
        int numberOfAnagrams = 0;
        for (int startSubStringLeft = 0; startSubStringLeft <= s.length(); startSubStringLeft++)
            for (int endSubStringLeft = startSubStringLeft + 1; endSubStringLeft <= s.length(); endSubStringLeft++) {
                char[] wordLeft = (s.substring(startSubStringLeft, endSubStringLeft)).toCharArray();
                char[] sortedWordLeft = Arrays.copyOf(wordLeft, wordLeft.length);
                Arrays.sort(sortedWordLeft);
                if (map.get(String.copyValueOf(sortedWordLeft)) == null) {
                    ArrayList<Pair<Integer, Integer>> tempArray = new ArrayList<Pair<Integer, Integer>>();
                    tempArray.add(new Pair(startSubStringLeft, endSubStringLeft));
                    map.put(String.copyValueOf(sortedWordLeft), tempArray);
                } else {
                    map.get(String.copyValueOf(sortedWordLeft)).add(new Pair(startSubStringLeft, endSubStringLeft));
                }
            }

        for (Map.Entry<String, ArrayList<Pair<Integer, Integer>>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                ArrayList<Pair<Integer, Integer>> currentList = entry.getValue();
                for (int i = 0; i < currentList.size(); i++) {
                    for (int j = i + 1; j < currentList.size(); j++) {
                        String firstWord = s.substring(currentList.get(i).getKey(), currentList.get(i).getValue());
                        String secondWord = s.substring(currentList.get(j).getKey(), currentList.get(j).getValue());
                   //     result.put(firstWord + "|" + secondWord, new Pair<String, String>(firstWord, secondWord));
                        counter++;
                    }
                }
            }


        }

        return counter;
    }

    public static void main(String[] args) {


        int a= sherlockAndAnagrams("ifailuhkqq");
    }

}
