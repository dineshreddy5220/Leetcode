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
    int paths;
    int total;
    public int pathSum(TreeNode root, int sum) {
        total=sum;
        dfs(root);
        return paths;
    }
    public void recursion(TreeNode root, int sum){
        if(root==null)
            return;
        sum-=root.val;
        if(sum==0)
            paths++;
        recursion(root.left,sum);
        recursion(root.right,sum);
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        recursion(root,total);
        dfs(root.left);
        dfs(root.right);
    }
}
