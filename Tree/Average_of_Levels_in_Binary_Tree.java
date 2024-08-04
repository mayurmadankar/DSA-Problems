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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        if (root == null) return avgList;
        
        Queue<TreeNode> levelOrder = new LinkedList<>();
        levelOrder.add(root);
        
        while (!levelOrder.isEmpty()) {
            int size = levelOrder.size();
            double sum = 0;
            int nodes = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = levelOrder.poll();
                sum += node.val;
                nodes++;
                
                if (node.left != null) levelOrder.add(node.left);
                if (node.right != null) levelOrder.add(node.right);
            }
            avgList.add(sum / nodes);
        }
        return avgList;
    }
}
