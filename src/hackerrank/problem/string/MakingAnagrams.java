package hackerrank.problem.string;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int sizeOfArray = 'z'-'a'+1;
        int [] countLeterWrodA = new int [sizeOfArray];
        int [] countLeterWrodB = new int [sizeOfArray];
        int result =0;

        for(int i=0;i<a.length();i++)
        {
            countLeterWrodA[a.charAt(i)-'a']+=1;
        }

        for(int i=0;i<b.length();i++)
        {
            countLeterWrodB[b.charAt(i)-'a']+=1;
        }

        for(int i=0;i<sizeOfArray;i++)
        {
            if(countLeterWrodA[i]>countLeterWrodB[i])
                result = result + (countLeterWrodA[i]-countLeterWrodB[i]);
            else
                result = result +  (countLeterWrodB[i] - countLeterWrodA[i]);
        }

        return result;


    }



    public static void main(String[] args) {

        makeAnagram("fcrxzwscanmligyxyvym","jxwtrhvujlmrpdoqbisbwhmgpmeoke");
    }
}
