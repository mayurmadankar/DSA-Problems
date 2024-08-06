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
    private int postIndex;
    private Map<Integer,Integer> InorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        InorderMap=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            InorderMap.put(inorder[i],i);
        }
        return buildTreeNode(postorder,0,inorder.length-1);
    }
    private TreeNode buildTreeNode(int[] postorder,int InorderStart,int InorderEnd){
        if(InorderStart>InorderEnd){
            return null;
        }
        int rootVal=postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int InorderIndex=InorderMap.get(rootVal);

        root.right=buildTreeNode(postorder,InorderIndex+1,InorderEnd);
        root.left=buildTreeNode(postorder,InorderStart,InorderIndex-1);

        return root;
    }
}