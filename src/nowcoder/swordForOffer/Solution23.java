package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/9/1.
 */
public class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0)
            return false;
        int len = sequence.length;
        return VerifySquenceOfBST(sequence,0,len-1);
    }

    private boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
        if(sequence==null || sequence.length==0)
            return false;
        if(start==end)
            return true;

        int root = sequence[end];
        int startRight;
        for(startRight=start;startRight<=end-1;startRight++)
        {
            if(sequence[startRight]>=root)
                break;
        }

        if(startRight==end)
            return VerifySquenceOfBST(sequence,start,end-1);
        for(int i=startRight;i<end;i++)
        {
            if(sequence[i]<root)
                return false;
        }
        if(startRight==start)
            return true;
        return VerifySquenceOfBST(sequence,start,startRight-1)&&
                VerifySquenceOfBST(sequence,startRight,end-1);
    }

    public static void main(String args[])  {
        Solution23 s = new Solution23();
        int[] a = new int[]{5,7,6,9,11,10,8};
        int[] b = new int[]{7,4,6,5};
        int[] c = new int[]{1,2,3,4};
        int[] d = new int[]{5,4,3,2,1};
        System.out.println(s.VerifySquenceOfBST(a));
        System.out.println(s.VerifySquenceOfBST(b));
        System.out.println(s.VerifySquenceOfBST(c));
        System.out.println(s.VerifySquenceOfBST(d));
        System.out.println(s.VerifySquenceOfBST(null));
    }

}
