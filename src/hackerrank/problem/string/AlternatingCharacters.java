package hackerrank.problem.string;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int sameCharEndIndex =0;
        int deletedCharsCounter =0;
        for(int i=0;i<s.length();i++)
        {
            sameCharEndIndex = i+1;
            while(sameCharEndIndex<s.length() && s.charAt(i)==s.charAt(sameCharEndIndex)) {
                deletedCharsCounter++;
                sameCharEndIndex++;
            }
            i=sameCharEndIndex-1;
        }

        return deletedCharsCounter;
    }


    public static void main(String[] args) {

      int result = alternatingCharacters("ffaacaddesdd");
    }

}
