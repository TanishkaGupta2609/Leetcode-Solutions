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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root==null)return 0;
        Queue<TreeNode> q=new LinkedList<>();
        List<Long> ans=new ArrayList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
                
            }
            ans.add(sum);
        }
        Collections.sort(ans);
        if(ans.size()<k){
            return -1;
        }
        return ans.get(ans.size()-k);
    }
}
