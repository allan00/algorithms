package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/29.
 */
public class Solution10 {
    public int RectCover(int target) throws Exception {
        if(target<0)
            throw new Exception("n must >=0");
        if(target==0)
            return 1;
        if(target==1 || target==2)
            return target;
        int val = 1,next =2,count = 2;
        int tmp;
        while(count<target) {
            tmp = next;
            next += val;
            val = tmp;
            count++;
        }
        return next;
    }

    public static void main(String args[]) throws Exception {
        Solution10 s = new Solution10();
        System.out.println(s.RectCover(1));
        System.out.println(s.RectCover(2));
        System.out.println(s.RectCover(3));
        System.out.println(s.RectCover(4));
        System.out.println(s.RectCover(5));
        System.out.println(s.RectCover(10));
    }
}
