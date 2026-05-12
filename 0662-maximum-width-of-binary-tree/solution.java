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
class pair{
    TreeNode node;
    int idx;
    pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int minIdx=q.peek().idx;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                pair cur=q.poll();
                int idx=cur.idx-minIdx;
                if(i==0)first=idx;
                if(i==size-1)last=idx;
                if(cur.node.left!=null)q.offer(new pair(cur.node.left,2*idx+1));
                if(cur.node.right!=null)q.offer(new pair(cur.node.right,2*idx+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
