package hackerrank.problem.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SherlockAndTheValidString {

    static String isValid(String s) {

        int sizeOfArray = 'z'-'a'+1;
        int [] countLeterWord = new int [sizeOfArray];

        for(int i=0;i<s.length();i++)
        {
            countLeterWord[s.charAt(i)-'a']+=1;
        }

        if(s.length()<=2)
            return "YES";
        else
        {
            int firstCounter =0;
            int secondCounter =0;

            for(int i=0;i<countLeterWord.length;i++)
            {
                if(firstCounter==countLeterWord[i] || countLeterWord[i]==0)
                    continue;
                else if(firstCounter==0 && countLeterWord[i]!=0)
                    firstCounter = countLeterWord[i];
                else if(secondCounter==0 && countLeterWord[i]!=0 && countLeterWord[i]!=firstCounter)
                    secondCounter = countLeterWord[i];
                else
                    return "NO";
            }

            if(secondCounter-firstCounter==1 || secondCounter-firstCounter==-1)
                return "YES";
            else if(secondCounter==1 || firstCounter==1)
                return "YES";
            else if(secondCounter==0)
                return "YES";


        }


        return "NO";
    }

    private  static Scanner scanner;

    public static void main(String[] args) throws IOException {

        File in = new File("input.txt");
        scanner = new Scanner(in);

        String s = scanner.nextLine();

        String result = isValid(s);

        scanner.close();    }

}
