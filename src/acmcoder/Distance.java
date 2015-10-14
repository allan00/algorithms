package acmcoder;

import java.util.Scanner;

/**
 * Created by ping on 2015/9/23.
 */
public class Distance {

    private static double getDistance(double x1,double y1,double x2,double y2)    {
        double dis = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        return dis;
    }
    public static void main(String args[])
    {
       double x1,x2,y1,y2;
        Scanner s = new Scanner(System.in);
        while(s.hasNext())    {
            x1 = s.nextDouble();
            y1 = s.nextDouble();
            x2 = s.nextDouble();
            y2 = s.nextDouble();
            System.out.println(String.format("%.2f\n",getDistance(x1, y1, x2, y2)));
        }
    }
}
