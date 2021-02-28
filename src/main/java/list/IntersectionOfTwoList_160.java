package list;

/**
 * 求两个链表的相交节点
 */
public class IntersectionOfTwoList_160 {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = lenOfList(headA);
        int lenB = lenOfList(headB);
        boolean isALongerThanB = true;
        int diff;
        if (lenA > lenB) {
            diff = lenA - lenB;
        } else {
            diff = lenB - lenA;
            isALongerThanB = false;
        }
        ListNode startA = headA, startB = headB;
        if (isALongerThanB) {
            for(int i = 1; i <= diff; i++) {
                startA = startA.next;
            }
        } else {
            for(int i = 1; i <= diff; i++) {
                startB = startB.next;
            }
        }
        while (startA != startB) {
            startA = startA.next;
            startB = startB.next;
        }
        return startA;
    }

    public static int lenOfList(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


}
