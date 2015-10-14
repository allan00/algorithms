package acmcoder.netease;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ping on 2015/10/9.
 */
public class Main {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n,r,avg;
        n = s.nextInt();
        r = s.nextInt();
        avg = s.nextInt();
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++) {
            a[i][0] = s.nextInt();
            a[i][1] = s.nextInt();
        }
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] a = (int[])o1;
                int[] b = (int[])o2;
                if(a[1]>b[1])     return 1;
                else                return -1;
            }
        };
        Arrays.sort(a, c);
        int total = avg*n;
        int min = 0;

        for(int i=0;i<n;i++)    {
            total -=a[i][0];
        }

        for(int i=0;i<n;i++)    {
            for (int j=1;j<=r-a[i][0];j++) {
                if (total<=0)    break;
                total--;
                min += a[i][1];
            }
            if (total<=0)    break;
        }
        System.out.println(min);
    }
}
