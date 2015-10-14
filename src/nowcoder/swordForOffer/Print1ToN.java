package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/30.
 */
public class Print1ToN {
    boolean overflow  = false;
    public void printOneToN(int n) {
        if (n<1)
            return;
        char[] num = new char[n];
        for(int i=0;i<n;i++)
            num[i]='0';

        while(!overflow){
            Increase(num);
            printNum(num);
        }

    }

    private void Increase(char[] num) {
        int numTokenOver = 1,numSum=0;
        int len = num.length;
        for(int i =len-1;i>=0;i--)  {
            numSum = num[i]-'0'+numTokenOver;
            numTokenOver = 0;

            if(numSum>=10){
                numSum -= 10;
                numTokenOver++;
                num[i] = (char)(numSum+'0');
            }
            else{
                num[i] = (char)(numSum+'0');
                break;
            }

            if(i==0 && numTokenOver>=1)  {
                overflow = true;
                break;
            }
        }
    }
    private void printNum(char[] num) {
        int start = num.length-1;
        for(int i=0;i<num.length;i++) {
            if(num[i]!='0'){
                start = i;
                break;
            }
        }

        for(int j=start;j<num.length;j++)   {
            System.out.print(num[j]);
        }
        System.out.println();
    }



    public static void main(String args[])  {
        Print1ToN p = new Print1ToN();
        p.printOneToN(2);
    }
}
