package hackerrank.problem.RecursionAndBacktracking;

public class FibonacciNumbers {

    public static void main(String[] args) {
        int num = fibonacci(8);

    }
    public static int fibonacci(int n) {

        if(n==1)
            return 1;
        if(n==0)
            return 0;

        return fibonacci(n-1)+fibonacci(n-2);

    }
}
