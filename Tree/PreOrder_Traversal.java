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
//  Recursive way:-

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         pre(root , result);
//         return result;
//     }
//     private static void pre(TreeNode root , List<Integer> result){
//         if(root==null){
//             return;
//         }
//         result.add(root.val);
//         pre(root.left , result);
//         pre(root.right , result);
//     }
// }

// Iterative way :-

class Solution {
    public List<Integer> preorderTraversal (TreeNode root){
        List<Integer> preorder = new LinkedList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root==null){
            return preorder;
        }
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            preorder.add(root.val);
            
            if(root.right!=null){
                st.add(root.right);
            }
            if(root.left!=null){
                st.add(root.left);
            }
        }
        return preorder;      
    }
}