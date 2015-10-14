package algorithms;

/**
 * Created by ping on 2015/8/15.
 */
public class KMP {
    String pat;
    int dfa[][];
    public  KMP(String pat)   {
        this.pat = pat;
        //generation DFA
        int M = pat.length();
        int X=0,R=256;
        //dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for(int j = 1;j<M; j++)
        {
            for(int c=0;c<R;c++)
            {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
    }
    public  int search(String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int i,j;
        for(i =0,j=0 ;j<M && i<N; i++)
        {
            j = dfa[txt.charAt(i)][j];
        }
        if(j==M)
            return i-M;
        else
            return N;
    }

    public static  void main(String args[])
    {
        String pat = "ABAB";
        String txt = "ABAAAAABAB";
        KMP kmp = new KMP(pat);
        System.out.println(kmp.search(txt));
    }

}
