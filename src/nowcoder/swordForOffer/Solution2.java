package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/29.
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        int len  =str.length();
        int N  = 0;
        int p1;

        //统计空格出现的次数
        for(int i=0;i<len;++i)
        {
            if(str.charAt(i)==' ')
                ++N;
        }

        str.setLength(len+2*N);         //扩容为len+2N

        for(p1=len-1;p1>=0;--p1) {
            if (str.charAt(p1) == ' ') {
                str.setCharAt(p1 + 2 * N, '0');
                str.setCharAt(p1 + 2 * N - 1, '2');
                str.setCharAt(p1 + 2 * N - 2, '%');
                --N;
            } else {
                str.setCharAt(p1 + 2 * N, str.charAt(p1));
            }
        }
        return str.toString();
    }

    public static void main(String args[])  {
        Solution2 s = new Solution2();
        StringBuffer str1 = new StringBuffer().append("we are happy students");
        StringBuffer str2 = new StringBuffer().append("I");
        StringBuffer str3 = new StringBuffer().append("You are  so  beautiful, so beautiful!!!");
        StringBuffer str4 = new StringBuffer().append("     ");
        System.out.println(s.replaceSpace(str1));
        System.out.println(s.replaceSpace(str2));
        System.out.println(s.replaceSpace(str3));
        System.out.println(s.replaceSpace(str4));
    }
}
