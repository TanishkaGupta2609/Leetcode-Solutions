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
    int maxx=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxx;
    }
    public int helper(TreeNode root){
        if(root==null)return 0;
        int lh=Math.max(0,helper(root.left));
        int rh=Math.max(0,helper(root.right));
        maxx=Math.max(maxx,lh+rh+root.val);
        return root.val+Math.max(lh,rh);
    }
}
