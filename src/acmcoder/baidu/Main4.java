package acmcoder.baidu;


import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ping on 2015/9/25.
 */
public class Main4 {
    static class Point{
        int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int N,M,K;
        N = s.nextInt();
        M = s.nextInt();
        K = s.nextInt();
        int[][] A = new int[N][M];
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
            A[i][j] = 0;
        for(int i=0;i<K;i++)    {
            int x = s.nextInt()-1;
            int y = s.nextInt()-1;
            A[x][y] = 1;
        }
        getP(A, N, M);
    }

    private static void getP(int[][] A,int N,int M) {
        double[][] f = new double[N][M];
        f[0][0] = 1;

        for(int i=1;i<N;i++) {
            if (A[i][0] == 0)
                f[i][0] = f[i - 1][0]*0.5;
            else
                f[i][0] = 0;
        }

        for(int j=1;j<M;j++) {
            if (A[0][j] == 0)
                f[0][j] = f[0][j - 1]*0.5;
            else
                f[0][j] = 0;
        }

        for (int i=1;i<N-1;i++)
            for (int j=1;j<M-1;j++)   {
                if(A[i][j] == 0)    {
                    f[i][j] = f[i-1][j]*0.5+f[i][j-1]*0.5;
                }
                else f[i][j] = 0;
            }

        for(int i=1;i<N-1;i++) {
            if (A[i][M-1] == 0)
                f[i][M-1] = f[i - 1][M-1]*1.0+f[i][M-2]*0.5;
            else
                f[i][M-1] = 0;
        }

        for(int j=1;j<M-1;j++) {
            if (A[N-1][j] == 0)
                f[N-1][j] = f[N-1][j-1]*1.0+f[N-2][j]*0.5;
            else
                f[N-1][j] = 0;
        }
        f[N-1][M-1] = f[N-2][M-1]+f[N-1][M-2];
        double p = f[N-1][M-1];
        System.out.println(String.format("%.2f", p));
    }

    private static void getP1(int[][] A,int N,int M) {
        long count,total = C(N+M-2,N-1);
        int[][] f = new int[N][M];

        f[0][0] = 1;
        for(int i=1;i<N;i++) {
            if (A[i][0] == 0)
                f[i][0] = f[i - 1][0];
            else
                f[i][0] = 0;
        }

        for(int j=1;j<M;j++) {
            if (A[0][j] == 0)
                f[0][j] = f[0][j - 1];
            else
                f[0][j] = 0;
        }

        for (int i=1;i<N;i++)
            for (int j=1;j<M;j++)   {
                if(A[i][j] == 0)    {
                    f[i][j] = f[i-1][j]+f[i][j-1];
                }
                else f[i][j] = 0;
            }
        count = f[N-1][M-1];
        double p = count*1.0/total;
        System.out.println(String.format("%.2f", p));
    }

    private static void getP2(int[][] A,int N,int M) {
        int[][] move = new int[][]{{1,0},{0,1}};
        int d;
        long count =0,total = (nMultiply(N+M-2)/(nMultiply(N-1)*nMultiply(M-1)));
        Point current = new Point(0,0);
        Stack<Point> s = new Stack<>();
        s.push(current);

        while(!s.isEmpty()) {
            current = s.pop();
            int x = current.x;
            int y = current.y;
            d = 0;
            while(d<2)  {
                int i = x+move[d][0];
                int j = y+move[d][1];
                if(isIllegal(i,j,N,M)) {
                    if(i==N-1 && j == M-1)    {
                        count++;
                    }
                    if(A[i][j] == 0)    {
                        current = new Point(i,j);
                        s.push(current);
                    }
                }
                d++;
            }
        }

        double p = count*1.0/total;
        System.out.println(String.format("%.2f", p));
    }

    private static void getP3(int[][] A,int N,int M) {
        int[][] move = new int[][]{{1,0},{0,1}};
        int d;
        long count =0,total = C(N+M-2,N-1);
        Point current = new Point(0,0);
        Stack<Point> s = new Stack<>();
        s.push(current);

        while(!s.isEmpty()) {
            current = s.peek();
            int x = current.x;
            int y = current.y;
            d = 0;
            while(d<2)  {
                int i = x+move[d][0];
                int j = y+move[d][1];
                if(isIllegal(i,j,N,M)) {
                    if(i==N-1 && j == M-1)    {
                        count++;
                        break;
                    }
                    if(A[i][j] == 0)    {
                        x = i;
                        y = j;
                        A[x][y] = -1;
                        current = new Point(x,y);
                        s.push(current);
                        d = 0;
                    }
                    else {
                        d++;
                    }
                }
                else d++;
            }
            s.pop();
        }

        double p = count*1.0/total;
        System.out.println(String.format("%.2f", p));
    }

    private static boolean isIllegal(int x,int y,int N,int M)   {
        return x>=0 && x<N && y>=0 && y<M;
    }

    private static long C(int a,int b){
        long result = a;
        int i = a,count = 1;
        while (count<=b){
            result *= i--;
            count++;
        }
        return result/nMultiply(b);
    }

    private static long nMultiply(int n){
        long result = 1;
        int i = 1;
        while (i<=n){
            result *= i++;
        }
        return result;
    }

}
