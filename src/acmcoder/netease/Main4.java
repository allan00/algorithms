package acmcoder.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ping on 2015/10/9.
 */
public class Main4 {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        String s1,s2;
        while (s.hasNext()) {
            s1 = s.nextLine();
            s2 = s.nextLine();
            System.out.println(String.format("%.2f",getP(s1,s2)*100)+"%");
        }
    }
    public static double getP(String s1,String s2)  {
        int count = 0;
        int len1  =s1.length(),len2 = s2.length();
        int total = len1>len2 ? len1 : len2;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s1.length();i++){
            char temp = s1.charAt(i);
            if(isOne(temp))
                sb.append("1");
            else
                sb.append("0");
        }
        String s3 = sb.toString();
        for(int i=0;i<len1&&i<len2;i++) {
            if(s3.charAt(i)==s2.charAt(i))
                count++;
        }
        return count*1.0/total;
    }

    private static boolean isOne(char c)    {
        int val = (int)c;
        if(c>=(int)'0'&& c<=(int)'9')
            return true;
        if(c>=(int)'A'&& c<=(int)'Z')
            return true;
        if(c>=(int)'a'&& c<=(int)'z')
            return true;
        return false;
    }
}
