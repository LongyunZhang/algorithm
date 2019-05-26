package list;

/**
 * Created by longyun on 2018/10/11.
 */


public class Linklist {
    static ListNode initListNode() {
        ListNode linkNode1 = new ListNode(1);
        ListNode linkNode2 = new ListNode(2);
        ListNode linkNode3 = new ListNode(3);
        ListNode linkNode4 = new ListNode(4);
        ListNode linkNode5 = new ListNode(5);
        ListNode linkNode6 = new ListNode(6);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        //linkNode3.next = linkNode4;
        //linkNode4.next = linkNode5;
       /* linkNode5.next = linkNode6;*/
        return linkNode1;
    }

    public static void main(String[] args) {
        ListNode head = initListNode();
        printList(head);
        //ListNode newHead = reverseList(head);

        ListNode newHead = removeOddNode(head);
       printList(newHead);

    }

    /**
     * 删除奇数结点
     */
    public static ListNode removeOddNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (curNode.next != null) {//从偶数结点开始，跳过奇数结点
                ListNode nn = curNode.next.next;
                ListNode n = curNode.next;
                curNode.next = nn;
                n.next = null;
                curNode = nn;
            } else {
                return newHead;
            }
        }
        return newHead;
    }

    /**
     * 链表倒置
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode headNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return headNode;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

