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
    private Map<Integer,Integer> InorderMap;
    private int preOrderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        InorderMap=new HashMap<>();
        preOrderIndex=0;

        for(int i=0;i<inorder.length;i++){
            InorderMap.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] preorder,int inorderStart,int inorderEnd){
        if(inorderStart>inorderEnd){
            return null;
        }
        int rootVal=preorder[preOrderIndex++];
        TreeNode root=new TreeNode(rootVal);

        root.left=buildTreeHelper(preorder,inorderStart,InorderMap.get(rootVal)-1);
        root.right=buildTreeHelper(preorder,InorderMap.get(rootVal)+1,inorderEnd);

        return root;
    }
}