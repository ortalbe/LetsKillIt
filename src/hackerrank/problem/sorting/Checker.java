package hackerrank.problem.sorting;

import java.util.Comparator;

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(b.score-a.score==0)
            return a.name.toLowerCase().compareTo(b.name.toLowerCase());

        return b.score-a.score;
    }
}