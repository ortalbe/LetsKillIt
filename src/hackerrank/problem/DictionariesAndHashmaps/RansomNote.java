package hackerrank.problem.DictionariesAndHashmaps;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {


        HashMap<Character, HashMap<String,Integer>> map = new HashMap<Character, HashMap<String,Integer>>();
        String result = "No";

        populateMap(map,magazine);
        result = checkNote(map,note);

        System.out.println(result);
    }

    private static String checkNote(HashMap<Character, HashMap<String,Integer>>  map, String[] note) {

        for(String currentWord:note)
        {
            if(map.get(currentWord.charAt(0))==null || map.get(currentWord.charAt(0)).get(currentWord)==null || map.get(currentWord.charAt(0)).get(currentWord)==0) {
                return "No";
            }
            else {
               int value = map.get(currentWord.charAt(0)).get(currentWord);
                map.get(currentWord.charAt(0)).replace(currentWord,value,value-1);
            }
        }

        return "Yes";

    }

    private static void populateMap(HashMap<Character, HashMap<String,Integer>> map, String[] magazine) {
        for(String currentWord:magazine)
        {
            if(map.get(currentWord.charAt(0))==null)
            {
                HashMap<String,Integer> newKeyValue = new HashMap<String,Integer>();
                newKeyValue.put(currentWord,1);
                map.put(currentWord.charAt(0),newKeyValue);

            }
            else {
                if(map.get(currentWord.charAt(0)).get(currentWord)==null)
                {
                    map.get(currentWord.charAt(0)).put(currentWord,1);
                }
                else {
                    int value = map.get(currentWord.charAt(0)).get(currentWord);
                    map.get(currentWord.charAt(0)).replace(currentWord, value, value + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        String magazineString = "two times three is not four";
        String [] magazine = magazineString.split(" ");

        String noteString = "two times two is four";
        String [] note = noteString.split(" ");

        checkMagazine(magazine,note);

    }
}
