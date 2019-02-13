package hackerrank.problem.sorting;

import tools.arrayUtils.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortingComparator {



    private static Random rand = new Random();
    public static void main(String[] args) {

        Player[] player = new Player[10];
        Checker checker = new Checker();

        for(int i = 0; i < 10; i++){
            player[i] = new Player(rand.nextInt(4), StringUtils.randomString(1));
        }


        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
