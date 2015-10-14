package algorithms.sort;

import java.util.Arrays;

/**
 * Created by qiuping01.wu on 2015/8/18.
 */
public class Quicksort  {

    public static void sort(int[] a)
    {
        sort(a,0,a.length-1);
    }

    private static void sort(int[] a,int lo,int hi)
    {
        if(hi<=lo)   return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(int[] a,int lo,int hi)
    {
        int i=lo,j=hi+1;
        int v =a[lo];
        while(true)
        {
            while(a[++i]<v) if(i==j) break;
            while(v<a[--j])  if(i==j) break;
            if(i>=j)    break;
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
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
        Quicksort.sort(a);
        printA(a);
        Arrays.sort(a);
        printA(a);
    }
}
