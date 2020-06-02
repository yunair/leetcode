package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II
 */
class P117FillNodeBinaryTree {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 迭代，保存父Node，用父Node的next项链
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        while (pre != null) {
            Node cur = pre;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                Node curNext = cur.next;
                // 找到一横排中有子节点的节点
                while (curNext != null && (curNext.left == null && curNext.right == null)) {
                    curNext = curNext.next;
                }
                if (curNext != null) {
                    final Node curNextLeaf;
                    if (curNext.left != null) {
                        curNextLeaf = curNext.left;
                    } else {
                        curNextLeaf = curNext.right;
                    }
                    if (cur.right == null) {
                        if (cur.left != null) {
                            cur.left.next = curNextLeaf;
                        }
                    } else {
                        cur.right.next = curNextLeaf;
                    }
                }

                cur = cur.next;
            }

            Node preNext = pre;
            Node next = null;
            while (next == null && preNext != null) {
                next = preNext.left;
                if (next == null) {
                    next = preNext.right;
                }
                preNext = preNext.next;
            }
            pre = next;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        P117FillNodeBinaryTree test = new P117FillNodeBinaryTree();
        test.connect(root);
        println(root);
    }

    private static void println(Node node) {
        Queue<Node> queue = new LinkedList<>();
        if (node == null) {
            return;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                System.out.print("#,");
                continue;
            }
            System.out.print(current.val + ",");
            Node next = current.next;
            while (next != null) {
                System.out.print(next.val + ",");
                next = next.next;
            }
            if (current.left != null) {
                queue.add(current.left);
            } else {
                queue.add(current.right);
            }
        }

    }
}