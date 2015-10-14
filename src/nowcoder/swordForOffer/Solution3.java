package nowcoder.swordForOffer;

import java.util.ArrayList;
/**
 * Created by ping on 2015/8/29.
 */

public class Solution3 {
    private ArrayList<Integer> aList;

    public Solution3() {
        aList  = new ArrayList<Integer>();
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) {
            return aList;
        }
        else {
            printListFromTailToHead(listNode.next);
            aList.add(listNode.val);
        }
        return aList;
    }

    public static void main(String args[])  {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution3 s = new Solution3();
        ArrayList<Integer> a = s.printListFromTailToHead(node1);
        System.out.print(" ");
        for(int i=0;i<a.size();i++) {
            System.out.print(a.get(i)+" ");
        }

        Solution3 s2 = new Solution3();
        ArrayList<Integer> a2 = s2.printListFromTailToHead(null);
        System.out.print(" ");
        for(int i=0;i<a2.size();i++) {
            System.out.print(a2.get(i)+" ");
        }
    }
}
