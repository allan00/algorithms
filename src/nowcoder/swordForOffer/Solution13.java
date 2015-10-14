package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/30.
 */
public class Solution13 {
    //时间：O(n)，空间O(n),稳定
    public void reOrderArray(int [] array) {
        if(array == null)
            return;
        int len = array.length;
        int[] newArray = new int[len];
        int i=0,j=0;
        for(i=0;i<len;i++)
        {
            if((array[i]&0x1) == 1)
                newArray[j++] = array[i];
        }
        for(i=0;i<len;i++)
        {
            if((array[i]&0x1) == 0)
                newArray[j++] = array[i];
        }

        for(i=0;i<len;i++)
        {
            array[i] = newArray[i];
        }
    }

    //时间：O(n)，空间O(1),不稳定
    public void reOrderArray2(int [] array) {
        if(array == null || array.length == 1)
            return;

        int p1=0,p2=array.length-1,tmp;
        while(p1<p2)
        {
            while(p1<=array.length-1 && (array[p1] & 0x1) == 1)
                ++p1;
            while(p2>=0 && (array[p2] & 0x1) == 0)
                --p2;
            if(p1 >= p2)
                return;
            else    {
                tmp = array[p1];
                array[p1] = array[p2];
                array[p2] = tmp;
            }
        }
    }

    public static void main(String args[])  {
        Solution13 s = new Solution13();
        int[] a1 =new int[]{1,2,3,4,5,6,7};
        int[] a2 =new int[]{1,3,5,7,9};
        int[] a3 =new int[]{2,4,6,8};
        int[] a4 =new int[]{1};
        s.reOrderArray(a1);
        s.reOrderArray(a2);
        s.reOrderArray(a3);
        s.reOrderArray(a4);
        System.out.print("hehe");
    }
}
