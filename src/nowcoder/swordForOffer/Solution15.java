package nowcoder.swordForOffer;

/**
 * Created by ping on 2015/8/30.
 */
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;

        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        while(next!=null) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }

    private void printList(ListNode head)
    {
        if(head==null)
            return;
        while(head!=null)   {
            System.out.print(head.val+"-> ");
            head  = head.next;
        }
        System.out.println();
    }
    public static void main(String args[])  {
        Solution15 s = new Solution15();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode one = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        s.printList(s.ReverseList(node1));
        s.printList(s.ReverseList(node5));

        s.printList(s.ReverseList(one));
        s.ReverseList(null);
    }
}
