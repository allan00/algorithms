package acmcoder;

import java.util.Scanner;

/**
 * Created by ping on 2015/10/1.
 */
public class P1000 {
    public static void main(String args[])
    {
        int A,B;
        Scanner s = new Scanner(System.in);
        while(s.hasNext())    {
            A = s.nextInt();
            B = s.nextInt();
            System.out.println(A+B);
        }
    }
}
