package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x,y;
    public Point(int x,int y) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class MazeBFS {
    public static void main(String[] args) {
        // 迷宫定义
        int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,1,1},
                        {1,0,1,1,1,0,1,1,0,1},
                        {1,1,0,0,1,1,0,1,0,1},
                        {1,0,1,1,0,0,1,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Queue<Point> q = new LinkedList<Point>();
        HashMap<Point,Integer> map = new HashMap<Point,Integer>();
        boolean flag = path(maze, move, q, map);
        if(!flag)   {
            System.out.println("不存在路径");
            return;
        }

        Point p = new Point(6,8);
        while(map.get(p)!=null)  {
            System.out.print(String.format("(%d,%d) <--",p.x,p.y));
            int d = map.get(p);
            int x = p.x-move[d][0];
            int y = p.y-move[d][1];
            p = new Point(x,y);
        }

    }
    public static boolean path(int[][] maze,int[][] move,Queue<Point> q,HashMap<Point,Integer> map){
        Point current = new Point(1,1); //起点
        Point next;
        q.offer(current);
        if(!map.containsKey(current))
            map.put(current, 1);
        while(!q.isEmpty()) {
            current = q.poll();
            int d = 0;
            while(d<8)  {
                int x = current.x+move[d][0];
                int y = current.y+move[d][1];
                if(x==6 && y==8) {
                    next = new Point(x, y);
                    q.offer(next);
                    if(!map.containsKey(next))
                        map.put(next, d);
                    return true;
                }
                else if(maze[x][y]==0)   {
                    maze[x][y] = -1;
                    q.offer(new Point(x, y));
                    next = new Point(x, y);
                    q.offer(next);
                    if(!map.containsKey(next))
                        map.put(next, d);
                }
                    d++;
            }
        }
        return false;
    }
}