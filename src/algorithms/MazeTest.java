package algorithms;

import java.util.Stack;
class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
        this.d = d;//方向
    }
}

public class MazeTest {

    public static void main(String[] args) {
        // 迷宫定义
        int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,1,1},
                        {1,0,1,1,1,0,1,1,1,1},
                        {1,1,0,0,1,1,0,0,0,1},
                        {1,0,1,1,0,0,1,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Stack<Step> s = new Stack();
        boolean flag = path(maze, move, s);

        Stack<Step> s2 = new Stack();
        while(!s.isEmpty()){
            s2.push(s.pop());
        }
        while(!s2.isEmpty()){
            Step step = s2.pop();
            System.out.print(String.format("(%d,%d)-->", step.x, step.y));
        }
    }
    public static boolean path(int[][] maze,int[][] move,Stack<Step> s){
        Step current = new Step(1,1,0); //起点
        s.push(current);
        while(!s.isEmpty()){
            current = s.peek();
            int x = current.x;
            int y = current.y;
            int d = current.d+1;
            while(d<8){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //该点可达
                    current = new Step(i,j,d); //到达新点
                    s.push(current);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //到达新点，标志已经到达
                    if(x == 6 && y == 8){
                        return true;  //到达出口，迷宫有路，返回true
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
            s.pop();
        }
        return false;
    }

}