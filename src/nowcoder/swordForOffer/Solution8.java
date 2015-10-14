package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/29.
 */
public class Solution8 {
    public int JumpFloor(int target) throws Exception {
        if(target<0)
            throw new Exception("n must >=0");
        if(target==0 || target==1 || target==2)
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
        Solution8 s = new Solution8();
        System.out.println(s.JumpFloor(1));
        System.out.println(s.JumpFloor(2));
        System.out.println(s.JumpFloor(3));
        System.out.println(s.JumpFloor(4));
        System.out.println(s.JumpFloor(5));
        System.out.println(s.JumpFloor(10));
    }
}
