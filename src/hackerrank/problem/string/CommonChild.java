package hackerrank.problem.string;

import tools.arrayUtils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        int maxElement=0;

       // creating all combination of first string
        int [][] subStrtingResult = new int [s1.length()][s2.length()];
        maxElement = createAllCombination(s1,s2,subStrtingResult);

        return maxElement;
    }

    private static int createAllCombination(String s1, String s2, int [][] subStrtingResult) {

        for(int i=0;i<=s1.length()-1;i++){
            for(int j=0;j<=s2.length()-1;j++){
                if(i==0 || j==0)
                {
                    if(s1.charAt(i)==s2.charAt(j)) {
                        if (i == 0 && j != 0)
                            subStrtingResult[i][j] = subStrtingResult[i][j - 1] + 1;
                        else
                            subStrtingResult[i][j] =1;

                    }
                    else
                    {
                        if(i==0 && j!=0)
                            subStrtingResult[i][j]=subStrtingResult[i][j-1];
                        else
                            subStrtingResult[i][j] =0;

                    }

                }

                else if(s1.charAt(i)==s2.charAt(j)){
                    subStrtingResult[i][j] = subStrtingResult[i-1][j-1]+1;
                }
                else{
                    subStrtingResult[i][j] = Math.max(subStrtingResult[i-1][j],subStrtingResult[i][j-1]);
                }
            }
        }
        return subStrtingResult[s1.length()-1][s2.length()-1];
    }



    private static boolean checkWord(String s, Map<Character, LinkedList<Integer>> s2Map) {

        int currentIndex =0;
        for(int i=0;i<s.length();i++)
        {
            LinkedList<Integer> indexs= s2Map.get(s.charAt(i));
            if(indexs==null)
                return false;
            for(Integer index:indexs)
                if(index>currentIndex)
                {
                    currentIndex=index;
                    break;
                }
                else
                    return false;

        }

        return true;
    }

    private static Map<Character,  LinkedList<Integer>> creatingMap(String s) {

        Map<Character,LinkedList<Integer>> map = new HashMap<Character,LinkedList<Integer>>();
        for(int i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i))!=null) {
                LinkedList<Integer> temp = map.get(s.charAt(i));
                temp.add(i);
                map.put(s.charAt(i),temp );
            }
            else
            {
                LinkedList<Integer> temp =new LinkedList<Integer>();
                temp.add(i);
                map.put(s.charAt(i),temp );
            }


        }
        return map;
    }

    public static void main(String[] args) {

        commonChild("MCB","MAC");
      }

}
