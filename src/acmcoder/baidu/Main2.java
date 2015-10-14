package acmcoder.baidu;


import java.util.Scanner;

/**
 * Created by ping on 2015/9/25.
 */
public class Main2 {

    public static long minArea(int[][] A)    {
        int X,Y;
        int minX = Integer.MAX_VALUE,maxX = Integer.MIN_VALUE,minY=Integer.MAX_VALUE,maxY = Integer.MIN_VALUE;

        for(int i=0;i<A.length;i++) {
            if(A[i][0]<minX)   minX = A[i][0];
            if(A[i][0]>maxX)   maxX = A[i][0];
            if(A[i][1]<minY)   minY = A[i][1];
            if(A[i][1]>maxY)   maxY = A[i][1];
        }
        X = maxX-minX;
        Y = maxY-minY;
        return X>Y?(long)X*(long)X:(long)Y*(long)Y;
    }
    public static void main(String args[])
    {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[][] A = new int[n][2];
        for(int i=0;i<n;i++) {
            A[i][0] = s.nextInt();
            A[i][1] = s.nextInt();
        }
        System.out.println(minArea(A));
    }
}
