package tree.serialize;

import common.TreeNode;
import util.TreeUtil;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 */
class P297SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("null").append(",");
            } else {
                sb.append(current.val).append(",");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] results = data.split(",");
        if (results.length < 1) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(results[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index + 1 < results.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (!Objects.equals(results[index], "null")) {
                    current.left = new TreeNode(Integer.parseInt(results[index]));
                    queue.add(current.left);
                }
                index++;
                if (!Objects.equals(results[index], "null")) {
                    current.right = new TreeNode(Integer.parseInt(results[index]));
                    queue.add(current.right);
                }
                index++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        P297SerializeAndDeserializeBinaryTree codec = new P297SerializeAndDeserializeBinaryTree();
        String result = codec.serialize(root);
        System.out.println(result);
        TreeUtil.printTreeNode(codec.deserialize(result));
    }
}
