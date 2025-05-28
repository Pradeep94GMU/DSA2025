/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ress = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //do the traversal in any order... 
        dfs(original, cloned, target);
        return ress;  
    }

    private void dfs(TreeNode original, TreeNode cloned, TreeNode target){
        if(original == null) return;

        if(original.val == target.val) {
            ress = cloned;
            return;
        } 

        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
        
    }
}