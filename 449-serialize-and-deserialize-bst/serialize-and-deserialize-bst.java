/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "N";
        String s = root.val + ","+serialize(root.left)+","+serialize(root.right);

        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data.length() == 0) return null;

       //constuct tree
       int[] idx = new int[1]; //rather than passing a single interger, as it will not be 
       //shared across muliple rec fun call, so better pass single length value which 
       //will be available across all ffun call.
       return constructTree(data, idx);

       
    }

    private TreeNode constructTree(String data,int[] idx){
        //System.out.println("org: "+data);
        if(data.length() <= idx[0]) return null;
        int start = idx[0];
        //mujhe idx ka use krke value nikalna hai
        while(data.length() > idx[0] && data.charAt(idx[0]) != ','){
            idx[0]++;
        }
        String s = data.substring(start, idx[0]);
        
        idx[0]++; //skip the , and go to the next char
        if(s.equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = constructTree(data, idx);
        root.right = constructTree(data, idx);
       
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;