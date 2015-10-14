package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/29.
 */

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length!=in.length || pre.length==0 || in.length==0)
            return null;

        TreeNode root = new TreeNode(pre[0]);
        int index = search(in,pre[0]);
        //root.left = reConstructBinaryTree();
        return root;
    }

    private int search(int [] a,int val) {
        for(int i=0;i<a.length;++i){
            if(a[i]==val)
                return i;
        }
        return -1;
    }
    public static void main(String args[])  {
        Solution2 s = new Solution2();

    }
}
