package hackerrank.problem.warmup;

public class RepeatedString {

    static long repeatedString(String s, long n) {

        long numberOfA =0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
                numberOfA++;
        }

        numberOfA = numberOfA * (n/s.length());

        for(int i=0;i<n%s.length();i++)
        {
            if(s.charAt(i)=='a')
                numberOfA++;
        }


        return numberOfA;
    }
}
