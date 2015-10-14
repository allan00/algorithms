package acmcoder.meituan;

public class Solution {
    //优化后的动态规划，缓存结果,时间复杂度为O(n)，空间复杂度为O(1)
    public static int findMaxDifference(int[] arr, int len) {
        int minPre=arr[0],minCurrent;//存储i之前的最小值
        int max = 0;
        for(int i=1;i<len;i++){
            minCurrent = arr[i]<minPre?arr[i]:minPre;
            if(arr[i]-minCurrent>max)
                max = arr[i]-minCurrent;
            minPre = minCurrent;
        }
        return max;
    }
    public static void main(String args[])  {
        int a[] = new int[]{5,10,3,11};
        int len = 4;
        System.out.println(findMaxDifference(a,len));



    }
}
