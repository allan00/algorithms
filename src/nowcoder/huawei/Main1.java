package nowcoder.huawei;

import java.util.Scanner;

/**
 * Created by ping on 2015/10/9.
 */
public class Main1 {
    public static int getLast(int n) {
        if(n<=2)    return n-1;
        int[] a = new int[n];
        int current=-1,last=0,count = n;

        for(int i=0;i<n;i++)
            a[i] = 1;

        while(count>0)  {
            do{
                current = (current+1)%n;
            }
            while(a[current]!=1);

            do{
                current = (current+1)%n;
            }
            while(a[current]!=1);

            do{
                current = (current+1)%n;
            }
            while(a[current]!=1);
            a[current] = 0;
            count--;
            last = current;
        }
        return last;
    }

    public static void main(String args[]){
        Scanner s =  new Scanner(System.in);
        int n;
        while(s.hasNext())  {
            n = s.nextInt();
            System.out.println(getLast(n));
        }
    }
}
