package nowcoder.dp;

import java.util.Scanner;

/**
 * Created by ping on 2015/9/20.
 */
public class ZeroOneBags {
    public static int maxValue(int[] weight,int [] value,int N,int capacity)  {
        int[][] f = new int[N+1][capacity+1];

        for (int i=1; i<=N; i++)
            for (int j=1; j<=capacity; j++)
            {
                if (weight[i]<=j)
                {
                    f[i][j]=max(f[i-1][j],f[i-1][j-weight[i]]+value[i]);
                }
                else
                    f[i][j]=f[i-1][j];
            }
        return f[N][capacity];
    }

    private static int max(int a,int b)   {
        return a>=b ? a:b;
    }

    public static void main(String ags[])  {
//        Scanner s = new Scanner(System.in);
//        int[][] a = new int[6][6];
//        for(int i=0;i<6;i++)
//            for(int j=0;j<6;j++)    {
//                a[i][j] = s.nextInt();
//            }

        int[] weight = new int[]{0,2,3,4,1,3,5};    //物品重量
        int[] value = new int[]{0,5,4,6,2,2,5};     //物品价值
        int N = 6;                                  //物品个数
        int capacity = 10;                          //背包容量
        System.out.println(maxValue(weight,value,N,capacity));
    }
}
