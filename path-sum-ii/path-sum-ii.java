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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        dfs(root,sum, new ArrayList<>());
        return result;
    }
    public void dfs(TreeNode root, int sum, List<Integer> list){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(sum==root.val){
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        dfs(root.left,sum-root.val,list);
        list.remove(list.size()-1);
        list.add(root.val);
        dfs(root.right,sum-root.val,list);
        list.remove(list.size()-1);
    }
}
