package doublepoint;

import common.ListNode;
import util.ListUtil;

/**
 * 环形链表
 */
class P141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        P141LinkedListCycle solve = new P141LinkedListCycle();
        System.out.println(solve.hasCycle(ListUtil.buildList(new int[]{1})));
        System.out.println(solve.hasCycle(ListUtil.buildList(new int[]{1})));
    }
}
