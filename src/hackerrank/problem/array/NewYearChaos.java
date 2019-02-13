package hackerrank.problem.array;

public class NewYearChaos {

    static void minimumBribes(int[] q) {

        int result = 0, temp=0;
        boolean success = true;

        int [] qtemp= new int[q.length];

        for(int i=0;i<q.length;i++)
            qtemp[i]=q[i];

        for (int i=qtemp.length;i>0;i--)
            for(int j=0;j<qtemp.length;j++) {
                if(qtemp[j]==i)
                {
                    temp=i-(j+1);
                    if(temp>2) {
                        System.out.println("Too chaotic");
                        success = false;
                        break;
                    }

                    // moving number to the end
                    for(int k=0;k<temp;k++) {
                        int tempSwap=qtemp[j+k];
                        qtemp[j+k] = qtemp[j +k + 1];
                        qtemp[j + k + 1] = tempSwap;
                    }
                    if(temp>0)
                        result+=temp;

                    break;
                }
                if(!success)
                    break;

            }

        if(success)
            System.out.println(result);
    }
}
