/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,List<PairNode>> order;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        order=new HashMap<>();
        dfs(root,0,0);
        List<List<Integer>> output=new ArrayList<>();
        List<Integer> keys=new ArrayList<>(order.keySet());
        Collections.sort(keys);
        for(Integer key:keys){
            List<PairNode> value=order.get(key);
            Collections.sort(value,(a,b)->a.level-b.level==0?a.val-b.val:a.level-b.level);
            ArrayList<Integer> list=new ArrayList<>();
            for(PairNode pair:value){
                list.add(pair.val);
            }
            output.add(list);
        }
        return output;
    }
    public void dfs(TreeNode root, int level, int position){
        if(root==null)
            return;
        List<PairNode> pair=order.getOrDefault(position,new ArrayList<>());
        pair.add(new PairNode(level,root.val));
        order.put(position,pair);
        dfs(root.left,level+1,position-1);
        dfs(root.right,level+1,position+1);
    }
}
class PairNode{
    int level;
    int val;
    public PairNode(int l,int v){
        level=l;
        val=v;
    }
}
