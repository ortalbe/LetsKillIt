package hackerrank.problem.RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Map;

public class DavisStaircase {

    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        int num=stepPerms(35);
        System.out.println(num);
    }

    static int stepPerms(int n) {

        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        if(!map.containsKey(n)) {
            int count = stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3);
            map.put(n, count);
        }
        return map.get(n);
    }

}
