package hackerrank.problem.search;

public class MaximumSubarraySum {

    static long maximumSum(long[] a, long m) {

        long max=0;
        long sum=0;

        for(int i=0;i<a.length;i++) {
            if (a[i]%m>max) {
                max = a[i] % m;
                if (max == m - 1)
                    return max;
            }
            sum=sum+a[i];
        }

        return checkSubArray(a,sum,m,max,0,a.length-1);


    }

    private static long checkSubArray(long[] a,long sum,long m, long max, int leftIndex,int rightIndex) {

        long sumLeft=0, sumRight=0;
        if( max==m-1)
            return max;
        if((rightIndex-leftIndex)<=0)
            return max;

        if(sum%m>max)
            max=sum%m;

        sumLeft=checkSubArray(a,sum-a[leftIndex],m,max,leftIndex+1,rightIndex);
        sumRight=checkSubArray(a,sum-a[rightIndex],m,max,leftIndex,rightIndex-1);

        if(sumLeft>sumRight)
            return sumLeft;
        else
            return sumRight;
    }

    public static void main(String[] args) {

        long [] arr= new long [] {3,3,9,9,5};
        System.out.println(maximumSum(arr,7));
    }

}
