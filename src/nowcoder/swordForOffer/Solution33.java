package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/9/1.
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1)
            return 0;
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextIndex = 1;
        int T2=0,T3=0,T5=0;

        while(nextIndex<index){
            int min= min(2*uglyNums[T2],3*uglyNums[T3],5*uglyNums[T5]);
            uglyNums[nextIndex] = min;
            while(2*uglyNums[T2] <= min)
                ++T2;
            while(3*uglyNums[T3] <= min)
                ++T3;
            while(5*uglyNums[T5] <= min)
                ++T5;
            ++nextIndex;
        }
        return uglyNums[index-1];
    }

    private int min(int a, int b, int c)    {
        int temp = a<b? a: b;
        return temp<c? temp: c;
    }

    public static void main(String args[])  {
        Solution33 s = new Solution33();
        System.out.println(s.GetUglyNumber_Solution(2));
        System.out.println(s.GetUglyNumber_Solution(3));
        System.out.println(s.GetUglyNumber_Solution(4));
        System.out.println(s.GetUglyNumber_Solution(0));
        System.out.println(s.GetUglyNumber_Solution(1500));
    }

}
