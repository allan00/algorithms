package acmcoder.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ping on 2015/9/23.
 */
public class Main2 {

    public static long getK(int[][] a, int k)   {
        int n= a.length;
        int m= a[0].length;
        if (k>(n+m-2)) return 0;
        //List pathList = getPathList(a,k);




        return 0;
    }
    private static List getPathList(int[][] a,int k,int i,int j)   {
        List pathList = new ArrayList<List<Integer>>();

        return pathList;
    }


    private static long funC(int a,int b)  {
        long r = nMulti(a)/(nMulti(b)*nMulti(a-b));
        return r;
    }

    private static long nMulti(int a)   {
        long result = 1;
        int i=1;
        while(i<=a) {
            result *= i;
            i++;
        }
        return result;
    }
    public static void main(String ags[])  {
        Scanner s = new Scanner(System.in);
        int n,m,k;
        n = s.nextInt();
        m = s.nextInt();
        k = s.nextInt();
        int[][] a = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j] = s.nextInt();

        System.out.println(getK(a,k));

    }
}
