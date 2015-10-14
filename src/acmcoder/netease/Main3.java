package acmcoder.netease;

import java.util.Scanner;

/**
 * Created by ping on 2015/10/9.
 */
public class Main3 {
    public static long MCD(long num1, long num2)
    {
        if(num1 < num2)
        {
            long temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while(num1%num2!=0)
        {
            long temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num2;
    }

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n;
        long a;
        long[] arr;
        while(s.hasNext())  {
            n = s.nextInt();
            a = s.nextLong();
            arr = new long[n];
            for(int i=0;i<n;i++)
                arr[i] = s.nextLong();
            System.out.println(getResult(a,arr));
        }
    }

    private static long getResult(long a,long[] arr) {
        long result = a;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=result)
                result += arr[i];
            else
                result += MCD(result,arr[i]);
        }
        return result;
    }
}
