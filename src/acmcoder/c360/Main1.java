package acmcoder.c360;

/**
 * Created by ping on 2015/9/29.
 */
import java.util.Scanner;

public class Main1 {

    public static int getNum(int[] a,int[][] relation)   {
        int count=0;
        int N = a.length,M = relation.length;
        for (int i=0;i<N;i++)   {
                a[i] = i;
        }
        for (int i=0;i<M;i++)   {
            int x = relation[i][0],y = relation[i][1];
            union(a,x,y);
        }

        for(int i=1;i<N;i++)    {
            if(find(a,0,i))  count++;
        }

        return count;
    }

    //qucick union
    private static void union(int[] a,int x,int y) {
            a[y] = a[x];
    }
    private static boolean find(int[] a,int x,int y) {
        int rootX=x,rootY=y;
        while(a[x]!=x)
            x = a[x];
        rootX = a[x];

        while(a[y]!=y)
            y = a[y];
        rootY = a[y];

        return rootX==rootY;
    }

    public static void main(String ags[])  {
        Scanner s = new Scanner(System.in);
        int N,M;
        N = s.nextInt();
        M = s.nextInt();
        while(true){
            int a[] = new int[N];
            int[][] relation = new int[M][2];
            for(int i=0;i<M;i++)    {
                relation[i][0] = s.nextInt()-1;
                relation[i][1] = s.nextInt()-1;
            }
            System.out.println(getNum(a,relation));
            N = s.nextInt();
            M = s.nextInt();
            if(N==0||M==0)
                break;
        }
    }
}

