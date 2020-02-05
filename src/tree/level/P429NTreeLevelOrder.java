package tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P429NTreeLevelOrder {
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


    private static class NodeWithLevel {
        final Node node;
        final int level;

        public NodeWithLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 0));
        while (!queue.isEmpty()) {
            NodeWithLevel current = queue.poll();

            if (current.node == null) {
                continue;
            }
            if (list.size() == current.level) {
                list.add(new ArrayList<>());
            }


            list.get(current.level).add(current.node.val);

            if (current.node.children == null) {
                continue;
            }
            for (Node child : current.node.children) {
                if (child != null) {
                    queue.add(new NodeWithLevel(child, current.level + 1));
                }
            }
        }
        return list;
    }
}
