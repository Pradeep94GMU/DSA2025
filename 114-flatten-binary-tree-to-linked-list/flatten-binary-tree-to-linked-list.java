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
    TreeNode node = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        
        flatten(root.left);
        //System.out.println(root.val);
        //this above is reverse preOrder..
        //node ka val root ke value ke barabar krte jao, left null kro and right to assign kr do??
       root.right = node;
       root.left = null;
       node = root;

        
        
        
    }
}