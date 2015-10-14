package acmcoder.meituan;

public class LongestDistance {
    public int getDis(int[] A, int n) {
        return getDis(A,0,n-1);
    }
    private int getDis(int[] A,int lo,int hi)	{
        int max1 = -1;
        for(int i=lo;i<=hi;i++)	{
            if( (A[i]-A[lo])>max1 )
                max1 = A[i]-A[lo];
        }
        if(lo==hi)	return max1;
        int max2 = getDis(A,lo+1,hi);
        
        return max1>max2?max1:max2;
    }
}