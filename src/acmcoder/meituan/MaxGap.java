package acmcoder.meituan;

/**
 * Created by ping on 2015/10/11.
 */
public class MaxGap {
    public static void main(String args[])  {
        int[] arr= new int[]{10,5};
        int len = arr.length;
        System.out.println(getResult(arr,len));
    }
    private static int getResult(int[] arr,int len){
        int max  = 0;
        for(int i=0;i<len;i++) {
            for (int j = i; j < len; j++) {
                if(arr[j]-arr[i]>max)
                    max = arr[j]-arr[i];
            }
        }
        return max;
    }
}
