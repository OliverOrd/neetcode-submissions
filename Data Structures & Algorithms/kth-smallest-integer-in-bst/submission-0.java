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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();

        inOrder(root, nums);

        return nums.get(k - 1);
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        inOrder(node.left, nums);

        nums.add(node.val);

        inOrder(node.right, nums);
    }
}
