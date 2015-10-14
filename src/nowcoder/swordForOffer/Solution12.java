package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/30.
 */
public class Solution12 {
    public double Power(double base, int exponent) {
        if (base==0 && exponent<0)
            return 0;
        boolean flag = exponent<0?true:false; //是否为负指数
        int e = Math.abs(exponent);
        double result = PowerWithUnsigned(base, e);
        if(flag)
            return 1/result;
        else
            return result;
    }

    private double PowerWithUnsigned(double base, int e) {
        if(e==0)
            return 1;
        if(e==1)
            return base;

        double result = PowerWithUnsigned(base,e>>1);
        result *= result;
        if ((e&0x1)==1)
            result *= base;

        return result;
    }

    public static void main(String args[])  {
        Solution12 s = new Solution12();
        System.out.println(s.Power(2,4));
        System.out.println(s.Power(0, 2));
        System.out.println(s.Power(0, -1));
        System.out.println(s.Power(-2, 9));
    }
}
