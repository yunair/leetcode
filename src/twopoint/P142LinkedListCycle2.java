package twopoint;

import common.ListNode;
import util.ListUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表2
 */
class P142LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }

        }

        if (!hasCycle) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        slow = head;
        fast = head.next;
        set.add(slow);
        while (!set.contains(fast)) {
            fast = fast.next;
            slow = slow.next;
            set.add(slow);
        }
        return fast;
    }

    public static void main(String[] args) {
        P142LinkedListCycle2 solve = new P142LinkedListCycle2();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next.next = head;
        System.out.println(solve.detectCycle(head));
        System.out.println(solve.detectCycle(ListUtil.buildList(new int[]{1})));
    }
}
