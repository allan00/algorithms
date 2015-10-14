package acmcoder.meituan;

import java.util.*;
public class AverageAge {
    static class Company	{
        int W;//公司总人数
        double	Y;//平均年龄
        double x;//离职率
        Company(int W,double Y,double x){
            this.W= W;
            this.Y = Y;
            this.x = x;
        }
    }
    
    public static void getAverage(Company c,int N)	{
        for(int i=0;i<N;i++)
            getNext(c);
    }

    public static void getNext(Company c)	{
        int W = c.W;
        double Y = c.Y;
        double x = c.x;
        Y = (W*(1-x)*(Y+1)+W*x*21)/W;
        c.Y = Y;        
    } 
    
    
    public static void main(String args[])	{
        Scanner s =  new Scanner(System.in);
        int W,N;
        double Y,x;
        W = s.nextInt();
        Y = s.nextDouble();
        x = s.nextDouble();
        N = s.nextInt();
        Company c = new Company(W,Y,x);     
        getAverage(c,N);    
        System.out.println((int)Math.ceil(c.Y));
        s.next();
    }
}