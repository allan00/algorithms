package algorithms.sort;

import java.util.Arrays;

/**
 * Created by qiuping01.wu on 2015/8/18.
 */
public class Quicksort3way {

    public static void sort(int[] a)
    {
        sort(a,0,a.length-1);
    }

    private static void sort(int[] a,int lo,int hi)
    {
        if(hi<=lo)   return;
        int lt = lo,i=lo+1,gt=hi;
        int v = a[lo];
        while(i<=gt)
        {
            if(a[i]<v)  swap(a,lt++,i++);
            else if(a[i]<v) swap(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void swap(int[] a,int i,int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printA(int[] a)
    {
        int N = a.length;
        for(int i=0;i<N; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String args[])  {
        int[] a = {3,4,6,1,77,34,2};
        printA(a);
        Quicksort3way.sort(a);
        printA(a);
        Arrays.sort(a);
        printA(a);
    }
}
