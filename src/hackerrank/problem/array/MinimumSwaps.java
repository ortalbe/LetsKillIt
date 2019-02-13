package hackerrank.problem.array;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int [] copyArr = new int [arr.length];
        int numberOfSwap = 0;

        for(int i=0;i<arr.length;i++)
            copyArr[i]=arr[i];

        for(int i=1;i<=copyArr.length;i++)
            for (int j=0;j<copyArr.length;j++)
            {
                if(i==copyArr[j]) {
                    if(i-1!=j) {
                        swapElement(j, i, copyArr);
                        numberOfSwap++;
                        break;
                    }
                }
            }

            return numberOfSwap;
    }

    private static void swapElement(int j, int i, int [] arr) {
        int temp = arr[j];
        arr[j]=arr[i-1];
        arr[i-1]=temp;

    }


}
