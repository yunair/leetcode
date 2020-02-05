package tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 */
class P589PreOrderNTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderSolve(root, result);
        return result;
    }

    private static void preorderSolve(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        if (node.children == null || node.children.isEmpty()) {
            return;
        }

        for (Node child : node.children) {
            preorderSolve(child, result);
        }
    }
}
