package test;

/**
 * N皇后问题：在一个N×N的棋盘上有N个皇后需要放置，求是否存在合理的放置方式？
 * （合理是指：棋盘上的N个皇后与其他任意一个皇后都不在同一行、同一列，以及对角线上。）
 *
 *思路：每一行都必定放置了一个皇后，故可以从第0行开始，一直放到N-1行。
 *①放置第一行的皇后，然后进行②，有n种方法。
 *②放置第二行的皇后，先检测自身的方法是否合理。不合理则返回false。合理则继续进行③，有N-2种放法
 * ......
 *③
 * Created by ping on 2015/8/16.
 */
public class QueensProblem {
    int N;
    int a[];

    public QueensProblem(int N)
    {
        this.N = N;
        a = new int[N];
        for (int y=0;y<N;y++)
        {
           a[y] = -1;
        }
    }

    public boolean hasSolution()
    {
        for (int y=0;y<N;y++)
        {
            if(place(0,y)) {
                System.out.print(N+"皇后问题的一个解：");
                for(int index = 0;index<N;index++)
                    System.out.print(a[index] + " ");
                System.out.println("");
                return true;
            }
        }
        return false;
    }

    /*place(i,j)表示把i行的皇后放到第j列*/
    public boolean place(int i,int j)
    {
        if(i<0||i>=N||j<0|j>=N)
            return false;
        a[i] = j;       //把第i行的皇后放在第j列

        for(int x=0;x<i;x++)//先检测自身是否合理
        {
            for(int y=x+1;y<=i;y++)
            {
                if(a[x]==a[y]||Math.abs(a[x]-a[y])==Math.abs(x-y)) {
                    a[i] = -1;  //若不合理，则回退
                    return false;
                }
            }
        }
        if(i==N-1)  return true;    //之前漏了这一行！！！如果没有这一行，这违背了递归算法的原则

        for (int y=0;y<N;y++)
        {
            if(place(i+1,y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[])   {
        for(int x = 1;x<10;x++)
        {
            new QueensProblem(x).hasSolution();
        }
    }
}
