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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else if(key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else{
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                TreeNode succes=FindMin(root.right);
                root.val=succes.val;
                root.right=deleteNode(root.right,succes.val);
            }
        }
        return root;
    }
    public TreeNode FindMin(TreeNode root){
        if(root==null)return null;
        if(root.left!=null){
            return FindMin(root.left);
        }
        return root;
    }
}
