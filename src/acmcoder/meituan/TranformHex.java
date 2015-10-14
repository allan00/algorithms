package acmcoder.meituan;

import java.util.Scanner;

/**
 * Created by ping on 2015/10/11.
 */
public class TranformHex {
    private static long tranfrom(String hex){
        long result = getVal(hex.charAt(0));
        for(int i=1;i<hex.length();i++) {
            result = getVal(hex.charAt(i))+result*16;
        }
        return result;
    }
    private static int getVal(char c){
        int val = (int)c;
        if(val>='0'&&val<='9')
            return val-(int)'0';
        switch (c){
            case 'a':return 10;
            case 'b':return 11;
            case 'c':return 12;
            case 'd':return 13;
            case 'e':return 14;
            case 'f':return 15;
            case 'A':return 10;
            case 'B':return 11;
            case 'C':return 12;
            case 'D':return 13;
            case 'E':return 14;
            case 'F':return 15;
        }
        return -1;
    }

    public static void main(String args[])  {
        Scanner s = new Scanner(System.in);
        String hex;
        while(s.hasNext()){
            hex  =s.next();
            System.out.println(tranfrom(hex));
        }
    }


}
