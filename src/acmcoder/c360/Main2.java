package acmcoder.c360;

/**
 * Created by ping on 2015/9/29.
 */
import java.util.Scanner;

public class Main2 {

    public static void getResult(char[][] a)   {
        int N = a.length;
        int M = 101;
        char[][] s = new char[N][M];  //Ŀ������
        for(int i=0;i<N;i++)			//��ʼ��Ϊ'\0'
            for(int j=0;j<M;j++)
                s[i][j]='\0';

        for(int i=0;i<N;i++)			//�����ַ�����
            getStr(a[i],s[i]);

        for(int i=0;i<N;i++) {			//��ӡ
            for (int j = 0; j < M; j++) {
                if (s[i][j] == '\0')    break;
                System.out.print(s[i][j]);
            }
            System.out.println();
        }
    }
    private static void getStr(char[] source,char[] goal)    {
        int p1=0,p2=0;   //p1ָ��source�е�Ԫ�أ�p2ָ��goal�е�Ԫ��
        while(p1<source.length) {
            if(p2<0)    p2=0;
            if(source[p1]=='#') p2--;		//ɾ��һ���ַ�
            else if(source[p1]=='@')    {	//�������
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

