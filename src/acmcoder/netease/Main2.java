package acmcoder.netease;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ping on 2015/10/9.
 */
public class Main2 {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n,l;
        double max,temp;
        n = s.nextInt();
        l = s.nextInt();
        int[] a = new int[n];

        for(int i =0;i<n;i++)
            a[i] = s.nextInt();
        Arrays.sort(a);
        max = a[0]-0;
        for(int i=0;i<n-1;i++){
            temp = (a[i+1]-a[i])/2.0;
            if(temp>max)
                max = temp;
        }
        temp = l-a[n-1];
        if(temp>max)
            max = temp;
        System.out.println(String.format("%.2f",max));
    }
}
