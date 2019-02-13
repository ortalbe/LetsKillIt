package hackerrank.problem.DictionariesAndHashmaps;

import tools.dataStructure.Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        ArrayList<Character> map = new ArrayList<Character>();

        for(int i=0;i<s1.length();i++)
        {
            if(map.size()==26)
                break;
            map.add(s1.charAt(i));
        }

        for(int i=0;i<s2.length();i++)
        {
            if(map.contains(s2.charAt(i)))
                return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {



    }
}
