package hackerrank.problem.warmup;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {

        int counter =0 ;
        int index =0 ;
        while(index<c.length-1)
        {
            if( index+2<c.length && c[index+2]==0)
            {
                index += 2;
                counter ++;
            }
            else if(index+1<c.length && c[index+1]==0 )
            {
                index++;
                counter++;
            }
            else
                throw new IllegalArgumentException();
        }

        return counter;
    }

}
