package tree.serialize;

import common.TreeNode;
import util.TreeUtil;

import java.util.*;

/**
 * 序列化和反序列化二叉搜索树
 */
class P449SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                sb.append(current.val).append(",");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                sb.append("#").append(",");
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
                if (!Objects.equals(results[index], "#")) {
                    current.left = new TreeNode(Integer.parseInt(results[index]));
                    queue.add(current.left);
                }
                index++;
                if (!Objects.equals(results[index], "#")) {
                    current.right = new TreeNode(Integer.parseInt(results[index]));
                    queue.add(current.right);
                }
                index++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{2, 1});
        P449SerializeAndDeserializeBST codec = new P449SerializeAndDeserializeBST();
        String result = codec.serialize(root);
        System.out.println(result);
        TreeUtil.printTreeNode(codec.deserialize(result));
    }
}
