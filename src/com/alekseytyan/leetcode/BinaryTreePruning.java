package com.alekseytyan.leetcode;

/**
 * Given the root of a binary tree, return the same tree where every subtree
 * (of the given tree) not containing a 1 has been removed.
 * A subtree of a node is node plus every node that is a descendant of node.
 *
 * Example 1:
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 * Example 2:
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 * Example 3:
 * Input: root = [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 200].
 * Node.val is either 0 or 1.
 */
public class BinaryTreePruning {
    public static TreeNode pruneTree(TreeNode root) {

        boolean isLeaf = true;

        if(root.left != null) {
            isLeaf = false;
            root.left = pruneTree(root.left);
        }

        if(root.right != null) {
            isLeaf = false;
            root.right = pruneTree(root.right);
        }

        if(root.val == 1) {
            return root;
        } else if(isLeaf) {
            return null;
        } else {
            return root.left != null || root.right != null
                ? root
                : null;
        }
    }

    public static void main(String[] args) {
        TreeNode input = prepareInput();
        TreeNode output = pruneTree(input);

        System.out.println(output);
    }

    private static TreeNode prepareInput() {
        return new TreeNode();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
