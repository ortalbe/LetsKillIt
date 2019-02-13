package hackerrank.problem.RecursionAndBacktracking;

import hackerrank.problem.search.Pairs;
import javafx.util.Pair;
import tools.arrayUtils.StringUtils;

import java.util.*;

import static java.lang.Character.isLetter;
import static java.lang.Character.isUpperCase;

public class CrosswordPuzzle {

    private enum Direction {VARTICAL,HORIZANTAL;};
    private static final int SIZE=10;
    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {

        String [] wordsArray = words.split(";");

        HashMap<Integer, Stack<String>> map = new  HashMap<Integer, Stack<String>>();

        fillMap(map,wordsArray);



        fillCrossword(crossword,map,0,0);


        return crossword;
    }



    private static void fillMap(HashMap<Integer, Stack<String>> map, String[] words) {

        for(String word:words)
        {
            if(map.get(word.length())==null)
            {
                Stack<String> wordPerLength = new  Stack<String>();
                wordPerLength.push(word);
                map.put(word.length(),wordPerLength);
            }
            else {
                Stack<String> wordPerLength =map.get(word.length());
                wordPerLength.push(word);
                map.put(word.length(),wordPerLength);
            }
        }
    }

    private static boolean fillCrossword(String[] crossword, HashMap<Integer, Stack<String>> map, int indexRow, int indexColm) {

      if(isFullMap(map))
          return true;
      if(indexColm==SIZE)
          return fillCrossword(crossword,  map,  indexRow+1,  0);

      if(crossword[indexRow].charAt(indexColm)=='-' || (isLetter(crossword[indexRow].charAt(indexColm)))) {
          if (fillWords(crossword, indexRow, indexColm, map))
              return fillCrossword(crossword, map, indexRow, indexColm + 1);
      }
      else
          return fillCrossword(crossword, map, indexRow, indexColm + 1);


          return false;
    }

    private static boolean fillWords(String[] crossword, int indexRow, int indexColm, HashMap<Integer, Stack<String>> map) {


        int sizeVartical = getSize(crossword,indexRow,indexColm,Direction.VARTICAL);
        int sizeHorizantal = getSize(crossword,indexRow,indexColm,Direction.HORIZANTAL);

        if(checkFullWord(crossword,indexRow,indexColm,sizeVartical,Direction.VARTICAL) && checkFullWord(crossword,indexRow,indexColm,sizeHorizantal,Direction.HORIZANTAL))
            return true;

        Stack<String> horizantalValidWord = map.get(sizeHorizantal);
        Stack<String> varticalValidWord = map.get(sizeVartical);

        if(sizeVartical>1 && varticalValidWord==null && !checkFullWord(crossword,indexRow,indexColm,sizeVartical,Direction.VARTICAL))
            return false;
        if(sizeHorizantal>1 && horizantalValidWord==null && !checkFullWord(crossword,indexRow,indexColm,sizeVartical,Direction.HORIZANTAL))
            return false;

        // only varticalWord
        if(sizeHorizantal==1 || checkFullWord(crossword,indexRow,indexColm,sizeVartical,Direction.HORIZANTAL))
        {
            for(int i=0;i<varticalValidWord.size();i++) {
                String currentWord= varticalValidWord.pop();
                if(!fillVerticalWord(crossword, indexColm, indexRow, indexRow + sizeVartical-1,currentWord ))
                    continue;
                else {
                    if(!fillCrossword(crossword, map, indexRow, indexColm + 1))
                        varticalValidWord.push(currentWord);
                }
            }
        }

       else if(sizeVartical==1 || checkFullWord(crossword,indexRow,indexColm,sizeVartical,Direction.VARTICAL))
        {
            for(int i=0;i<horizantalValidWord.size();i++)  {
                String currentWord= horizantalValidWord.pop();
                if(!fillHorizontalWord(crossword, indexRow,indexColm , indexColm + sizeHorizantal-1, currentWord))
                    continue;
                else {
                    if(!fillCrossword(crossword, map, indexRow, indexColm + 1))
                        horizantalValidWord.push(currentWord);
                }
            }
        }
        else
        {
            for(int i=0;i<varticalValidWord.size();i++) {
                String currentWord= varticalValidWord.pop();
                if(!fillVerticalWord(crossword, indexColm, indexRow, indexRow + sizeVartical-1,currentWord ))
                {
                    for(int j=0;j<horizantalValidWord.size();j++)  {
                        String currentWordHo= horizantalValidWord.pop();
                        if(!fillHorizontalWord(crossword, indexRow,indexColm , indexColm + sizeHorizantal-1, currentWordHo))
                            continue;
                        else {
                            if(!fillCrossword(crossword, map, indexRow, indexColm + 1))
                                horizantalValidWord.push(currentWordHo);
                            return true;
                        }
                    }
                }
                else {
                    if(!fillCrossword(crossword, map, indexRow, indexColm + 1))
                        varticalValidWord.push(currentWord);
                }
            }
        }


        return false;
    }

    private static boolean checkFullWord(String[] crossword, int indexRow, int indexColm, int size, Direction direction) {

        if (size<=0)
            return true;

        for(int i=0;i<size;i++)
        {
            if(direction==Direction.VARTICAL && !(isLetter(crossword[indexRow+i].charAt(indexColm))))
                return false;
            if(direction==Direction.HORIZANTAL && !(isLetter(crossword[indexRow].charAt(indexColm+i))))
                return false;

        }

        return true;
    }

    private static boolean isLetter(char currentChar) {
        if(currentChar>='A' && currentChar<='Z')
            return true;

        return false;
    }


        private static boolean wordFull(String[] crossword, int indexRow, int indexColm, int size, Direction direction) {
        if(direction == Direction.HORIZANTAL)
        {
            for(int i=0;i<size;i++)
            if(crossword[indexRow].charAt(i+indexColm)=='-')
                return false;
        }

        if(direction == Direction.VARTICAL)
        {
            for(int i=0;i<size;i++)
                if(crossword[indexRow+i].charAt(indexColm)=='-')
                    return false;
        }
        return true;
    }



    private static Integer getSize(String[] crossword, int indexRow, int indexColm, Direction direction) {
        int size=0;

        if(direction==Direction.VARTICAL) {
            while (indexRow + size < SIZE && crossword[indexRow + size].charAt(indexColm) != '+') {
                size++;
            }
        }
        if(direction==Direction.HORIZANTAL)
        {
            while(indexColm+size<SIZE &&  crossword[indexRow].charAt(indexColm+size)!='+')
            {
                size++;
            }
        }
        return size;
    }


    private static boolean isFullMap( HashMap<Integer, Stack<String>> map) {
        for(Map.Entry<Integer, Stack<String>> entry:map.entrySet())
            if(entry.getValue().size()!=0)
                return false;

            return true;
    }


    private static boolean fillVerticalWord(String[] crossword, int column, int firstIndex, int lastIndex,String currentWord) {

        int p=0;
        for(int j=firstIndex;j<lastIndex+1;j++) {
            if(crossword[j].charAt(column)!='-' && crossword[j].charAt(column)!=currentWord.charAt(p))
                return false;
            crossword[j] = crossword[j].substring(0,column)+currentWord.charAt(p)+crossword[j].substring(column+1);
                p++;
            }

            return true;
    }


    private static boolean fillHorizontalWord(String[] crossword, int row, int firstIndex, int lastIndex,String currentWord) {
        char [] wordAsArray = new char[crossword[row].length()];
        int p=0;
        String newWord="";
        for(int j=0;j<crossword[row].length();j++) {
            if(j>=firstIndex && j<=lastIndex) {
                if(crossword[row].charAt(firstIndex+p)!='-' &&   currentWord.charAt(p)!=crossword[row].charAt(firstIndex+p))
                    return false;
                newWord = newWord+currentWord.charAt(p);
                p++;
            }
            else
            {

                newWord=newWord+crossword[row].charAt(j);
            }

        }
        crossword[row]=newWord;

        return true;
    }

    public static void main(String[] args) {

        String [] crossword = new String [] {"+-++++++++","+-++++++++","+-++++++++",
                                "+-----++++","+-+++-++++","+-+++-++++","+++++-++++",
                                "++------++","+++++-++++","+++++-++++"};
        String words = "LONDON;DELHI;ICELAND;ANKARA";
        crosswordPuzzle(crossword,words);
        printPuzzle(crossword);
    }

    private static void printPuzzle(String[] crossword) {

        for(int i=0;i<crossword.length;i++)
        {
            System.out.println();
            for(int j=0;j<crossword.length;j++)
                System.out.print(" " + crossword[i].charAt(j));
        }

    }
}
