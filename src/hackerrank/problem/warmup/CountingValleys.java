package hackerrank.problem.warmup;

public class CountingValleys {

    public static int countingValleys(int n, String s) {

        int counter =0;
        int currentHeight=0;
        boolean newVally=true;

        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='D')
                currentHeight--;
            else if (s.charAt(i)=='U')
                 currentHeight++;
            if (currentHeight==0)
                newVally=true;
            if(currentHeight<0 && newVally)
            {
                newVally=false;
                counter++;
            }

        }

        return counter;
    }
}
