package hackerrank.problem.array;

public class ArrayTwoD {

    static int hourglassSum(int[][] arr) {
        int maxValue=-100;
        int tempValue=-100;

        for (int i=2;i<arr.length;i++)
            for(int j=2;j<arr.length;j++)
            {
                tempValue=calculateHourglass(arr,i,j);
                if(tempValue>maxValue)
                    maxValue=tempValue;
            }

            return maxValue;
    }

    private static int calculateHourglass(int[][] arr, int rowLimit, int columnLimit) {
        int sum=0;
        sum=arr[rowLimit-2][columnLimit-2]+arr[rowLimit-2][columnLimit-1]+arr[rowLimit-2][columnLimit]+arr[rowLimit-1][columnLimit-1]+arr[rowLimit][columnLimit-2]+arr[rowLimit][columnLimit-1]+arr[rowLimit][columnLimit];

        return sum;
    }

    public static void main(String[] args) {

        int [][] arr = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
         System.out.println(hourglassSum(arr));
    }

}
