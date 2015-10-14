package acmcoder.meituan;

public class Solution {
    //�Ż���Ķ�̬�滮��������,ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)
    public static int findMaxDifference(int[] arr, int len) {
        int minPre=arr[0],minCurrent;//�洢i֮ǰ����Сֵ
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
