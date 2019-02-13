package hackerrank.problem.string;


import java.util.Stack;

public class SpecialPalindromeAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        long counter =0;

        for (int startIndex=0;startIndex<n;startIndex++)
            for(int endIndex=startIndex;endIndex<n;endIndex++)
            {
                int result = checkPolindrom(s,startIndex,endIndex);
               if(result==0)
                    counter++;
               else if(result == -2)
                   break;


            }

            return counter;
    }

    private static int checkPolindrom(String s, int startIndex, int endIndex) {

        int i=startIndex;
        int j = endIndex;
        char reference = s.charAt(i);
        while(i<j)
        {
            if(s.charAt(i)!=reference || s.charAt(j)!=reference)
            {
                if(s.charAt(i)!=reference && s.charAt(j)!=reference)
                    return -2;
                return -1;
            }


            i++;
            j--;
        }

        return 0;
    }


    public static void main(String[] args)  {
       System.out.println(substrCount(7,"abcbaba"));

    }
}
