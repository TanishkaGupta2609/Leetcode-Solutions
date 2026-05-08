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
    int maxx=0;
    public int diameterOfBinaryTree(TreeNode root) {
       diameter(root);
       return maxx;
    }
    public int diameter(TreeNode root){
        if(root==null)return 0;
        int lh=diameter(root.left);
        int rh=diameter(root.right);
        maxx=Math.max(maxx,lh+rh);
        return 1+Math.max(lh,rh);
    }
}
