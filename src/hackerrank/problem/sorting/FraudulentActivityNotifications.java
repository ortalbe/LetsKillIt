package hackerrank.problem.sorting;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FraudulentActivityNotifications {

    private static Random rand = new Random();
    private static final int MAX_RANDOM_VALUE = 200;

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int numberOfNotification =0;
        int startIndex,endIndex;
        float median=0;
        int[] tempArray = new int [MAX_RANDOM_VALUE];
        for(int i=d;i<expenditure.length;i++)
        {
            endIndex=i;
            startIndex= i-d;
            if(i==d)
            {
                creatingTempArray(tempArray,expenditure,startIndex,endIndex);
            }
            else
                modifeyArray(tempArray,expenditure,startIndex,endIndex);

            median=fetchMedian(tempArray,d);
            if(2*median<=expenditure[i])
                numberOfNotification++;
        }

        return numberOfNotification;
    }

    private static void modifeyArray(int[] tempArray, int[] expenditure,int startIndex, int endIndex) {
        tempArray[expenditure[startIndex-1]]-=1;
        tempArray[expenditure[endIndex-1]]+=1;
    }

    private static float fetchMedian(int[] tempArray, int d) {
        boolean evenSize = false;
        int counter=0;
        int firstMedian=0, secondMedian=0;

        if(d%2==1)
            evenSize=true;

        for(int i=0;i<tempArray.length;i++)
        {

            counter+=tempArray[i];
            if(counter>=(float) d/2)
            {
                firstMedian=i;
                if(counter-d/2>=1)
                    secondMedian=i;
                else
                    for(int j=i+1;j<tempArray.length;j++)
                        if(tempArray[j]>0) {
                            secondMedian = j;
                            break;
                        }
                break;
            }

        }

        if(evenSize)
            return (float) firstMedian;
        else
            return (float) ((firstMedian+secondMedian)/2.0);
    }

    private static void creatingTempArray( int[] tempArray, int[] expenditure, int startIndex, int endIndex) {

        for(int i=0;i<endIndex-startIndex;i++)
            tempArray[expenditure[startIndex+i]]+=1;

    }

    public static void main(String[] args) throws IOException {

        File in = new File("input.txt");
        Scanner scanner = new Scanner(in);

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        long startTime = System.nanoTime();
       /* int n = 9 ;
        int d=5;
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
    */  /*  int [] expenditure = new int [n];


        for (int i = 0; i < n; i++) {
            int expenditureItem = rand.nextInt(MAX_RANDOM_VALUE)+1;
            expenditure[i] = expenditureItem;
        }*/


  /*      String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);*/


        String expenditureItemsString = scanner.nextLine();
        scanner.close();
        Pattern SPACE = Pattern.compile(" ");
        String[] expenditureItems = SPACE.split(expenditureItemsString);


        int[] expenditure = new int[n];

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
           // System.out.println(i);
        }

        int result = activityNotifications(expenditure, d);

        long endTime = System.nanoTime();
        System.out.println("Result : " + result);
        System.out.println("Time : " + (endTime-startTime));
    }
}
