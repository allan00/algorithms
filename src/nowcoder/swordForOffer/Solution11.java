package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/29.
 */
public class Solution11 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0) {
            n &= (n-1);
            ++count;
        }
        return count;
    }

    public static void main(String args[])  {
        Solution11 s = new Solution11();
        System.out.println("0中1的个数： "+s.NumberOf1(0));   //11=8+2+1
        System.out.println("11中1的个数： "+s.NumberOf1(11));   //11=8+2+1                   00000000000000000000000000001011
        System.out.println("6中1的个数： "+s.NumberOf1(6));   //6=4+2                        00000000000000000000000000000110
        System.out.println("127中1的个数： "+s.NumberOf1(127));   //127=64+32+16+8+4+2+1     00000000000000000000000001111111
        System.out.println("-127中1的个数： "+s.NumberOf1(-127));    //                      11111111111111111111111110000001
    }
}
