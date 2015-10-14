package acmcoder.jd;

import java.util.Scanner;

/**
 * Created by ping on 2015/9/19.
 */
public class AnnualPrize {
//    public static int dp2(int[][] a){
//        int N=a.length;
//        for(int i=1; i<N; i++){
//            a[i][0]+=a[i-1][0];
//        }
//        for(int j=1; j<N; j++){
//            a[0][j]+=a[0][j-1];
//        }
//        for(int i=1; i<N; i++){
//            for(int j=1; j<N; j++){
//                a[i][j] += Math.max(    a[i-1][j]  ,   a[i][j-1]      );
//            }
//        }
//        return a[N-1][N-1];
//    }

    public static int maxPrizes(int[][] a)    {
        int maxN = 1 << 10;
        int maxValue = 0;
        for(int i=0;i<maxN;i++) {
            if(isLegal(i))  {
                int val = getValue(a,i);
                if(maxValue<val)    maxValue = val;
            }
        }

        return maxValue;
    }
    private static int getValue(int[][] a,int v)    {
        int i=0,j=0;
        int value = a[0][0];
        for(int cursor=0;cursor<10;cursor++)  {
            int bit = v&0x1;
            if(bit==1)  j++;
            else i++;
            value +=a[i][j];
            v >>= 1;
        }
        return value;
    }

    private static int getValue2(int[][] a,int v)    {
        int i=0,j=0;
        int value = a[0][0];
        String V = Integer.toBinaryString(v);
        while(V.length()<10)
            V = '0'+V;
        for(int cursor=0;cursor<V.length();cursor++)  {
            if(V.charAt(cursor)=='1')  i++;
            else j++;
            value +=a[i][j];
        }
        return value;
    }

    private static boolean isLegal(int i)   {
        if( i>=(1<<10) )  return false;
        int count = 0;
        while(i>0)  {
            i &=(i-1);
            count++;
        }
        if (count==5)   return true;
        else return false;
    }

    public static void main(String ags[])  {
        Scanner s = new Scanner(System.in);
//        int[][] a = new int[6][6];
//        for(int i=0;i<6;i++)
//            for(int j=0;j<6;j++)    {
//                a[i][j] = s.nextInt();
//            }
        int[][] a = new int[][]{{200,120,400,150,180,300},
                {150,250,360,120,200,130},
                {350,300,250,100,500,260},
                {100,150,260,320,100,150},
                {500,130,260,100,200,170},
                {160,100,250,200,600,200}};
        System.out.println(maxPrizes(a));
    }
}
