package algorithms;

/**
 * Created by ping on 2015/8/18.
 */
public class Fib {
    public static long Fib(int n) throws Exception {
        if(n<0)
            throw new Exception("N必须大于等于0");
        if(n==0||n==1)
            return 1;
        int current =1,next =1;
        int index=1,temp;
        while(index<n)
        {
            temp = next;
            next = next+current;
            current = temp;
            index++;
        }
        return next;
    }

    public static void main (String args[]) throws Exception {
        for(int i=0;i<10;i++)
        {
            System.out.println(Fib.Fib(i));
        }

    }
}
