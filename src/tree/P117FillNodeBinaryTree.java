package tree;

import java.util.LinkedList;
import java.util.Queue;

class P116FillNodeFullBinaryTree {
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
     * 把完美二叉树劈成两半，先处理大的两半二叉树中间的左右连接，然后递归处理小的连接
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }

    /**
     * BFS遍历
     */
    public Node connectUseNSpace(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                final Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
            }
        }

        return root;
    }
}
