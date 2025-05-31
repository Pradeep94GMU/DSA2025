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
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap();
        List<TreeNode> result = new ArrayList();

        sol(root, map, result);
        return result;
        
    }

    private String sol(TreeNode node,HashMap<String, Integer> map,  List<TreeNode> result ){
        if(node == null) return "N";
        String subTree = "" + node.val + "," + sol(node.left, map, result) + ","+ sol(node.right,map, result);
        map.put(subTree, map.getOrDefault(subTree, 0) + 1);
        if(map.getOrDefault(subTree, 0) == 2){
            result.add(node);
        }
        

        return subTree;
        
    }
}