package tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 */
class P590PostOrderNTree {
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
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderSolve(root, result);
        return result;
    }

    private static void postorderSolve(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.children == null || node.children.isEmpty()) {
            result.add(node.val);
            return;
        }

        for (Node child : node.children) {
            postorderSolve(child, result);
        }
        result.add(node.val);
    }
}
