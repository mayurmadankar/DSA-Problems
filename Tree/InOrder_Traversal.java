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

//  Recursive Way :-

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inOrderHelper(root , result);
//        return result;
//     }
//     private static void inOrderHelper(TreeNode node , List<Integer> result){
//         if(node == null){
//             return;
//         }
//         inOrderHelper(node.left , result);
//         result.add(node.val);
//         inOrderHelper(node.right , result);
        
//     }
// }

// Iterative way :-

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> inorder = new LinkedList<Integer>();
        TreeNode node = root;
        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder;
    }
}