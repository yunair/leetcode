package tree.depth;

import java.util.List;

class P559MaxDepthNtree {
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
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int max = 0;

        for (Node child : root.children) {
            final int depth = maxDepth(child);
            if (depth > max) {
                max = depth;
            }
        }
        return max + 1;
    }
}
