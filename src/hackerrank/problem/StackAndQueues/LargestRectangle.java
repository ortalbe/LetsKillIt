package hackerrank.problem.StackAndQueues;
import java.util.Stack;
public class LargestRectangle {


    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        int size = h.length;
        int index = 0;
        int maxArea = 0, tempArea = 0;
        int top = -1;
        Stack<Integer> stack = new Stack<Integer>();

        while (index < size) {
            if (stack.isEmpty() || h[stack.peek()] < h[index]) {
                stack.push(index);
                index++;
            } else {
                top = stack.pop();
                if (stack.isEmpty())
                    tempArea = h[top] * (index);
                else
                    tempArea = h[top] * (index - stack.peek() - 1);

                if (tempArea > maxArea)
                    maxArea = tempArea;


            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();
            if (stack.isEmpty())
                tempArea = h[top] * (index);
            else
                tempArea = h[top] * (index - stack.peek() - 1);

            if (tempArea > maxArea)
                maxArea = tempArea;

        }
        return maxArea;
    }


    // Driver program to test above function
        public static void main(String[] args)
        {
            int hist[] = { 2,3,4,5,1};
            System.out.println("Maximum area is " + largestRectangle(hist));
        }
    }

