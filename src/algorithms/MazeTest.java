package algorithms;

import java.util.Stack;
class Step{
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//������
        this.y = y;//������
        this.d = d;//����
    }
}

public class MazeTest {

    public static void main(String[] args) {
        // �Թ�����
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
        Step current = new Step(1,1,0); //���
        s.push(current);
        while(!s.isEmpty()){
            current = s.peek();
            int x = current.x;
            int y = current.y;
            int d = current.d+1;
            while(d<8){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //�õ�ɴ�
                    current = new Step(i,j,d); //�����µ�
                    s.push(current);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //�����µ㣬��־�Ѿ�����
                    if(x == 6 && y == 8){
                        return true;  //������ڣ��Թ���·������true
                    }else{
                        d = 0;  //���³�ʼ������
                    }
                }else{
                    d++; //�ı䷽��
                }
            }
            s.pop();
        }
        return false;
    }

}