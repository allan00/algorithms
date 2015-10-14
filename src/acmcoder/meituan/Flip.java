package acmcoder.meituan;

/**
 * Created by ping on 2015/9/24.
 */
import java.util.*;

public class Flip {
    static class Point	{
        int x;
        int y;
        Point(int x,int y)	{
            this.x = x;
            this.y = y;
        }
    }
    public static int[][] flipChess(int[][] A, int[][] f) {
        List<Point> list = new ArrayList<Point>();
        for(int i=0;i<f.length;i++)	{
            if(isIllegal(f[i][0]-1,f[i][1]))
                list.add(new Point(f[i][0]-1,f[i][1]));
            if(isIllegal(f[i][0]+1,f[i][1]))
                list.add(new Point(f[i][0]+1,f[i][1]));
            if(isIllegal(f[i][0],f[i][1]-1))
                list.add(new Point(f[i][0],f[i][1]-1));
            if(isIllegal(f[i][0],f[i][1]+1))
                list.add(new Point(f[i][0],f[i][1]+1));
        }

        Iterator it = list.iterator();
        while(it.hasNext())	{
            Point p = (Point)it.next();
            A[p.x-1][p.y-1] = getOpposite(A[p.x-1][p.y-1]);
        }

        return A;
    }

    private static boolean isIllegal(int x,int y)	{
        return x>=1&&x<=4&&y>=1&&y<=4;
    }

    private static int getOpposite(int a)	{
        return a==1?0:1;
    }

    public static void main(String args[])  {
        int[][] A = new int[][]{{0,0,1,1},
                                {1,0,1,0},
                                {0,1,1,0},
                                {0,0,1,0}};
        int[][] f1 = new int[][]{{2,2},{3,3},{4,4}};
        int[][] B = new int[][]{{0,1,0,0},
                                {1,0,1,0},
                                {1,1,0,0},
                                {1,0,0,1}};
        int[][] f2 = new int[][]{{2,3},{4,2},{2,3}};
        int[][] C = flipChess(A,f1);
        int[][] D = flipChess(B,f2);
        D = flipChess(B,f2);
        int i=0;



    }


}