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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       inOrderHelper(root , result);
       return result;
    }
    private static void inOrderHelper(TreeNode node , List<Integer> result){
        if(node == null){
            return;
        }
        inOrderHelper(node.left , result);
        result.add(node.val);
        inOrderHelper(node.right , result);
        
    }
}