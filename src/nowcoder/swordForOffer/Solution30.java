package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/9/1.
 */
public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) throws Exception {
        if (array == null)
            throw new Exception("The array must not be null!");
        if (array.length == 0)
            return 0;

        int max = array[0], sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            }
            else {
                sum += array[i];
            }
            if (sum >= max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String args[])  throws Exception{
        Solution30 s = new Solution30();
        int[] a = new int[]{1,-2,3,10,-4,7,2,-5};
        int[] b = new int[]{-7,-4,-6,-5};
        int[] c = new int[]{5,4,3,2,1};
        int[] d = new int[]{-1};
        System.out.println(s.FindGreatestSumOfSubArray(a));
        System.out.println(s.FindGreatestSumOfSubArray(b));
        System.out.println(s.FindGreatestSumOfSubArray(c));
        System.out.println(s.FindGreatestSumOfSubArray(d));
        System.out.println(s.FindGreatestSumOfSubArray(null));
    }

}
