package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/30.
 */
public class Solution6 {
    public int minNumberInRotateArray(int [] array) throws Exception{
        if(array==null || array.length==0)
            return 0;

        int len = array.length;
        int index1  = 0,index2  = len-1,mid = index1;

        while(array[index1]>=array[index2]) {
            if((index2-index1)==1) {
                return array[index2];
            }

            mid  = index1+ (index2-index1)/2;
            if(array[index1] == array[mid] && array[mid] == array[index2])
                return minInOrder(array);

            if (array[mid]>=array[index1])   {
                index1 = mid;
            }
            else{
                index2 = mid;
            }
        }

        return array[mid];
    }

    private int minInOrder(int[] array)  {
        int min = 0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]<array[min])
                min = i;
        }
        return array[min];
    }

    public static void main(String args[]) throws Exception {
        Solution6 s = new Solution6();
        int[] a = new int[]{3,4,5,1,2};
        int[] b = new int[]{3,3,3,1,3};
        int[] c = new int[]{3};
        int[] d = new int[]{1,2,3,4,5,6};
        int[] e = new int[]{1,1,1,0,0,1};
        int[] f = new int[]{2,2,1,2,2};
        System.out.println(s.minNumberInRotateArray(a));
        System.out.println(s.minNumberInRotateArray(b));
        System.out.println(s.minNumberInRotateArray(c));
        System.out.println(s.minNumberInRotateArray(d));
        System.out.println(s.minNumberInRotateArray(e));
        System.out.println(s.minNumberInRotateArray(f));
        //System.out.println(s.minNumberInRotateArray(null));

    }
}
