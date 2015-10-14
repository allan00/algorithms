package algorithms;

/**
 * Created by ping on 2015/8/15.
 */
public class BM {
    String pat;
    int[] right;

    public BM(String pat)
    {
        this.pat = pat;
        int R = 256;
        int M = pat.length();
        right = new int[R];
        for(int i=0;i<R;i++)
            right[i] = -1;
        for(int j=0;j<M;j++)
            right[pat.charAt(j)] = j;
    }

    public int search(String txt)
    {
        int skip;
        int N = txt.length();
        int M = pat.length();
        for(int i=0;i<=N-M;i += skip)
        {
            skip = 0;
            for(int j=M-1;j>=0;j--)
                if(pat.charAt(j)!=txt.charAt(i+j))
                {
                    skip = j-right[txt.charAt(i+j)];
                    if(skip<1) skip = 1;
                    break;
                }
            if(skip ==0)    return i;
        }
        return N;
    }
    public static void main(String args[])
    {
        String pat = "ABAB";
        String txt = "ABAAAAABAB";
        BM bm = new BM(pat);
        System.out.println(bm.search(txt));
    }
}
