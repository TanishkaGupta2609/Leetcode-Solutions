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
class tuple{
    TreeNode node;
    int row;
    int col;
    tuple(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<tuple> q=new LinkedList<>();
        q.offer(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple t=q.poll();
            TreeNode node=t.node;
            int x=t.row;
            int y=t.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
        
        if(node.left!=null){
            q.offer(new tuple(node.left,x-1,y+1));
        }
        if(node.right!=null){
            q.offer(new tuple(node.right,x+1,y+1));
        }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> node :ys.values()){
                while(!node.isEmpty()){
                    ans.get(ans.size()-1).add(node.poll());
                }
            }
        }
        return ans;
    }

}
