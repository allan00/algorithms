package acmcoder.c360;

/**
 * Created by ping on 2015/9/29.
 */
import java.util.Scanner;

public class Main2 {

    public static void getResult(char[][] a)   {
        int N = a.length;
        int M = 101;
        char[][] s = new char[N][M];  //目标数组
        for(int i=0;i<N;i++)			//初始化为'\0'
            for(int j=0;j<M;j++)
                s[i][j]='\0';

        for(int i=0;i<N;i++)			//进行字符操作
            getStr(a[i],s[i]);

        for(int i=0;i<N;i++) {			//打印
            for (int j = 0; j < M; j++) {
                if (s[i][j] == '\0')    break;
                System.out.print(s[i][j]);
            }
            System.out.println();
        }
    }
    private static void getStr(char[] source,char[] goal)    {
        int p1=0,p2=0;   //p1指向source中的元素，p2指向goal中的元素
        while(p1<source.length) {
            if(p2<0)    p2=0;
            if(source[p1]=='#') p2--;		//删掉一个字符
            else if(source[p1]=='@')    {	//清掉正行
                clear(goal,p2);
                p2=0;
            }
            else    {
                goal[p2] = source[p1];
                p2++;
            }
            p1++;
        }
    }
    private static void clear(char[] goal,int len)    {
        for(int i=0;i<goal.length&&i<=len;i++)
            goal[i] = '\0';
    }

    public static void main(String ags[])  {
        Scanner s = new Scanner(System.in);
        int N;
        N = s.nextInt();
        char[][] a = new char[N][];
        s.nextLine();

        for(int i=0;i<N;i++) {
            String temp = s.nextLine();
            a[i] = temp.toCharArray();
        }
        getResult(a);
    }
}

