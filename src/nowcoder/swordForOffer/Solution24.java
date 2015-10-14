package nowcoder.swordForOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by ping on 2015/9/1.
 */


public class Solution24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Stack<Integer> path = new Stack<Integer>();
        path.push(1);
        path.push(2);
        Iterator it = path.iterator();
        while (it.hasNext())
        {
            System.out.print(it.next()+" ");
        }
        return null;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[])  {
        Solution24 s = new Solution24();
        s.FindPath(null,0);
    }

}

