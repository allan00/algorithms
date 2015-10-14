package acmcoder.jd;

import java.util.Scanner;

/**
 * Created by ping on 2015/9/23.
 */
public class Main1 {

    public static int getRemian(int M,int[][] a)   {
        int count = 0;
        for(int i=0;i<=M;i++) {
            if(!isExist(a,i))
                count++;
        }
        return count;
    }

    private static boolean isExist(int[][] a, int num)   {
        for(int i=0;i<a.length;i++) {
            if(num>=a[i][0]&&num<=a[i][1])
                return true;
        }
        return false;
    }
    public static void main(String ags[])  {
        Scanner s = new Scanner(System.in);
        int M,N;
        M = s.nextInt();
        N = s.nextInt();
        int[][] a = new int[N][2];
        for(int i=0;i<N;i++)
            for(int j=0;j<2;j++)
                a[i][j] = s.nextInt();

        System.out.println(getRemian(M,a));

    }
}
