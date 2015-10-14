package acmcoder.meituan;

public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        // write code here
        int maxArea = 0,area;
        for(int width=1;width<=n;width++)	{
            for(int i=0;i<=n-width;i++)	{
                area = getArea(A,i,i+width-1);
                if(area>maxArea)
                    maxArea =area;                
            }
        }
        return maxArea; 
    }
    
    private int getArea(int[] A,int lo,int hi)	{
        int min = Integer.MAX_VALUE;
        for(int i=lo;i<=hi;i++)
            if(A[i]<min)	min = A[i];
        return min*(hi-lo+1);
    }
}