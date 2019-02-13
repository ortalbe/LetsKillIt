package hackerrank.problem.StackAndQueues;

import java.util.Stack;

public class BalancedBrackets {

    static String isBalanced(String s) {
        if(s.length()%2==1)
            return "NO";

        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')')
            {
                if(stack.isEmpty() || !('('==stack.pop()))
                 return "NO";
            }
            else if(s.charAt(i)==']' )
            {
                if(stack.isEmpty() || !('['==stack.pop()))
                return "NO";
            }
            else if(s.charAt(i)=='}') {
                if(stack.isEmpty() ||!('{'==stack.pop()))
                 return "NO";
            }
            else
                stack.push(s.charAt(i));
        }

        if(stack.isEmpty())
            return "YES";
        else
            return "NO";
    }
    public static void main(String[] args) {
        System.out.print(isBalanced("{[()]}"));
    }
}
