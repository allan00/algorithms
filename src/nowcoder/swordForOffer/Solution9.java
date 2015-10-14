package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/30.
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        if(target<1)
            return -1;
        int count=1,result = 1;
        while(count<target)
        {
            result <<= 1;
            count++;
        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        Solution9 s = new Solution9();
        System.out.println(s.JumpFloorII(1));
        System.out.println(s.JumpFloorII(2));
    }
}
