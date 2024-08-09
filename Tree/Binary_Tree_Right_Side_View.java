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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root,result,0);
        return result;
    }
    public void rightSideView(TreeNode curr , List<Integer> result , int currDepth){
        if(curr==null){
            return;
        }
        if(currDepth==result.size()){
            result.add(curr.val);
        }
        rightSideView(curr.right,result,currDepth+1);
        rightSideView(curr.left,result,currDepth+1);
    }
}
//tc-O(n)
//sc-O(height)