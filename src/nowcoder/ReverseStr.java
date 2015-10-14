package nowcoder;

public class ReverseStr {
    public String ReverseSentence(String str) {
        if(str==null || str.length()<=1)	return str;
        char[] a = str.toCharArray();
        reverse(a,0,a.length-1);
        System.out.println(new String(a));
        int start = 0, end = 0;
        while(start<a.length && end<a.length)	{
            if(a[end]!=' ')	end++;
            else	{
                reverse(a,start,end-1);
                start = (++end);
            }
        }
        reverse(a,start,a.length-1);
        return new String(a);
    }
    
    private void reverse(char[] s,int start,int end)	{
        if(s==null || (end-start)<=0)	return;
        int p1 = start, p2 = end;
        while(p1<p2)	{
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;
            p1++;
            p2--;
        }
    }

    public static void main(String[] args)
    {
        ReverseStr r = new ReverseStr();
        System.out.println(r.ReverseSentence("I am a student."));
    }
}