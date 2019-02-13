package hackerrank.problem.StackAndQueues;

public class CastleOnTheGrid {

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int minMoves=0;

        return minMoves;

    }

    public static void main(String[] args)
    {
        String [] grid = new String [3];
        grid[0] = ".X.";
        grid[1] = ".X.";
        grid[2] = "...";

        System.out.print(minimumMoves(grid,0,0,0,2));
    }
}
