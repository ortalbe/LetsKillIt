package hackerrank.problem.RecursionAndBacktracking;

public class RecursiveDigitSum {

    static int superDigit(String n, int k) {

        n=n.chars().mapToLong(Character::getNumericValue).sum()*k+"";


        if(n.length()>1) {
            return superDigit(n,1);
        }
        else
            return Integer.parseInt(n);

    }



    public static void main(String[] args) {
        System.out.print(superDigit("123",3));
    }
}
