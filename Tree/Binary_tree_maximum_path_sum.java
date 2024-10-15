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
 
 //tc-O(n)
 //sc-O(H)- BECASUE OF RECURSIVE STACK

class Solution {
    private int maxSum = Integer.MIN_VALUE; // To store the maximum path sum globally

    public int maxPathSum(TreeNode root) {
        maxGain(root); // Start the recursion from the root
        return maxSum; // Return the maximum path sum
    }

    // Helper function to calculate maximum gain starting from the node
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0; // Base case: return 0 for null nodes
        }

        // Recursively calculate the maximum gain from left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0); // Ignore negative gains by using Math.max(0, ...)
        int rightGain = Math.max(maxGain(node.right), 0);

        // Calculate the path sum that passes through the current node (including both children)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum path sum if the current path sum is greater
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain if we continue from the current node
        return node.val + Math.max(leftGain, rightGain);
    }
}
