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
    public int sumNumbers(TreeNode root) {
        return sumsHelper(root,0);
    }
    public int sumsHelper(TreeNode node, int currentSum){
        if(node==null){
            return 0;
        }
        currentSum=currentSum*10+node.val;

        if(node.left==null && node.right==null){
            return currentSum;
        }

        int leftSum=sumsHelper(node.left,currentSum);
        int rightSum=sumsHelper(node.right,currentSum);

        return leftSum+rightSum;
    }
}
//time Complexity -O(n)
//space complecity -O(n) in worst case (skewed tree) :- and O(log n) in best case balance tree