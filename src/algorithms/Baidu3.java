package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ping on 2015/9/17.
 */
public class Baidu3 {
    static class Point {
        int x;
        int y;
    }

    public static int min(int n, Point[] points)  {
        int minX = Integer.MAX_VALUE,maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE,maxY = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)    {
            if(points[i].x<minX)  minX = points[i].x;
            if(points[i].x>maxX)  maxX = points[i].x;
            if(points[i].y<minY)  minY = points[i].y;
            if(points[i].y>maxY)  maxY = points[i].y;
        }
        int X = maxX-minX;
        int Y = maxY-minY;
        return X>Y ? (X*X) : (Y*Y);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputN = input.readLine();
        int n = Integer.valueOf(inputN);
        if(n<=0) return;
        Point[] points = new Point[n];
        for(int i=0;i<n;i++ )   {
           points[i] = new Point();
        }
        for(int i=0;i<n;i++ )   {
            String str = input.readLine();
            int index  = str.indexOf(' ');
            points[i].x = Integer.valueOf(str.substring(0,index));
            points[i].y = Integer.valueOf(str.substring(index+1));
        }
        System.out.println(min(n,points));
    }
}
