package algorithms;

import java.util.*;

public class MazeDFS {
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
        Stack<Step> s = new Stack<Step>();
        boolean flag = path(maze, move, s);
        if(!flag)   {
            System.out.println("不存在路径");
            return;
        }

    }
    public static boolean path(int[][] maze,int[][] move,Stack<Step> s){
        Step current = new Step(1,1,1); //起点
        Step next;
        s.push(current);
        while(!s.isEmpty()) {
            current = s.peek();
            int x = current.x;
            int y = current.y;
            int d = 0;
            while(d<8)  {
                 x += move[d][0];
                 y += current.y+move[d][1];
                if(x==6 && y==8) {
                    s.push(new Step(6,8,d));
                    return true;
                }
                else if(maze[x][y]==0)   {
                    maze[x][y] = -1;
                    s.push(new Step(6,8,d));
                    d = 0;
                }
                else
                    d++;
            }
        }
        return false;
    }
}