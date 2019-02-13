package tools.arrayUtils;

import java.util.Random;

public class StringUtils {

    private static final String CHAR_LIST =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int NUMBER_OF_CHAR = 62;
    private static Random rand = new Random();

    public static String randomString (int size)
    {
        String result="";
        for(int i=0;i<size;i++)
            result+=(String.valueOf(CHAR_LIST.charAt(rand.nextInt(NUMBER_OF_CHAR))));

        return result;
    }
}
