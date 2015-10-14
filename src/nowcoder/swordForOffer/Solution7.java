package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/29.
 */
public class Solution7 {
    public int Fibonacci(int n) throws Exception {
        if(n<0)
            throw new Exception("n must >=0");
        if(n==0||n==1)
            return n;
        int val = 0,next =1,count = 1;
        int tmp;
        while(count<n) {
            tmp = next;
            next += val;
            val = tmp;
            count++;
        }
        return next;
    }

    public static void main(String args[]) throws Exception {
        Solution7 s = new Solution7();
        System.out.println(s.Fibonacci(3));
        System.out.println(s.Fibonacci(5));
        System.out.println(s.Fibonacci(10));
    }
}
