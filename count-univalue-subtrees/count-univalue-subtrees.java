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
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null){
            return 0;
        }
        boolean b=subTree(root,root.val);
        int left=countUnivalSubtrees(root.left);
        int right=countUnivalSubtrees(root.right);
        return left+right+(b==true?1:0);
    }
    public boolean subTree(TreeNode root,int val){
        if(root==null){
            return true;
        }
        if(root.val!=val){
            return false;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        return subTree(root.left,val) && subTree(root.right,val);
    }
}
