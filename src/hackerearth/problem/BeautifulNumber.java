package hackerearth.problem;

import java.util.Scanner;

public class BeautifulNumber {

        public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        int numberOfTestCase = Integer.parseInt(name);

        for(int i=0;i<numberOfTestCase;i++)
        {
            String number = s.nextLine();                 // Reading input from STDIN
            long beauityNumber = Long.parseLong(number);
            System.out.println(calculateBeautyNumber(beauityNumber));
        }

        }

    private static long calculateBeautyNumber(long beauityNumber) {
            boolean limitPass=false;
            long maxLimit=0;
            long sumOfOnes=0;

            while(!limitPass) {
                maxLimit++;
                sumOfOnes = (long) (Math.pow(2, maxLimit - 1) * maxLimit);
                if (sumOfOnes > beauityNumber) {
                    limitPass = true;
                    maxLimit=maxLimit-1;
                }
            }

        sumOfOnes= (long) (Math.pow(2, maxLimit - 1) * maxLimit);
        long baseNumber= sumOfOnes-1;
            while(sumOfOnes<beauityNumber)
            {
                baseNumber=baseNumber+1;
                sumOfOnes=sumOfOnes+getBeauty(baseNumber);

            }

            return baseNumber;
    }

    public static int getBeauty (long number)
        {
            int beauty =0;

            while(number>0) {
                beauty += number & 1;
                number = number / 2;
            }

            return beauty;
        }



}
