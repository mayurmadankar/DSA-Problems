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
 //tc-O(H+K)
 //sc-O(H)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack =new Stack<>();
        TreeNode currNode =root;

        while(currNode!=null || !stack.isEmpty()){

            //traverse toward left side
            while(currNode!=null){
                stack.push(currNode);
                currNode =currNode.left;
            }
            //pop that curr node from stack
            currNode=stack.pop();
            k--;
            if(k==0){
                return currNode.val;
            }
            //otherwise move toward right
            currNode=currNode.right;
        }
        //if k is larger than the number of the nodes
        return -1;
    }
}