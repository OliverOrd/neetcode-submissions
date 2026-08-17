/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    boolean isInvalid;

    public boolean isValidBST(TreeNode root) {
        validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return !isInvalid;
    }

    private void validate(TreeNode node, long min, long max) {
        if (node == null) {
            return;
        }

        int val = node.val;
        if (val <= min || val >= max) {
            isInvalid = true;
        }

        validate(node.left, min, val);
        validate(node.right, val, max);
    }
}
