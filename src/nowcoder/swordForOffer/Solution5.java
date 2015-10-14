package nowcoder.swordForOffer;

import java.util.Stack;

/**
 * Created by ping on 2015/8/29.
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if(stack2.isEmpty())
        {
            if(stack1.isEmpty())
                throw new Exception("the queue is empty,can not pop!");
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String args[]) throws Exception {
        Solution5 s = new Solution5();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.print(s.pop() + " " + s.pop() + " " + s.pop() + " " + s.pop() + " ");
        s.push(5);
        System.out.print(s.pop());
    }
}
