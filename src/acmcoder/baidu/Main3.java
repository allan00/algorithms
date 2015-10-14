package acmcoder.baidu;


import java.util.Scanner;

/**
 * Created by ping on 2015/9/25.
 */
public class Main3 {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n,m,x,y,t;
        n = s.nextInt();
        m = s.nextInt();
        x = s.nextInt();
        y = s.nextInt();
        t = s.nextInt();
        double[][] A = new double[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            A[i][j] = s.nextDouble();
        getResult(A, x, y, t);
    }

    private static void getResult(double[][] A, int x, int y, int t) {
        double p1 = A[x-1][y-1];
        double cc = 1-Math.pow(1-p1,t);
        double p2 = 0;
        double ss;
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++)
                p2 += A[i][j];
        p2 = p2/(A.length*A[0].length);
        ss = 1-Math.pow(1-p2,t);
        if(cc>ss) {
            System.out.println("cc");
            System.out.println(String.format("%.2f",cc));
        }
        else if(cc<ss) {
            System.out.println("ss");
            System.out.println(String.format("%.2f",ss));
        }
        else  {
            System.out.println("equal");
            System.out.println(String.format("%.2f",cc));
        }
    }
}
