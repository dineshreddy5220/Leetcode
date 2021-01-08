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
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result=new ArrayList<>();
        recursion(root,new StringBuilder());
        return result;
    }
    public void recursion(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            sb.append(root.val);
            result.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(root.val+"->");
        recursion(root.left,sb);
        sb.delete(sb.lastIndexOf(root.val+""),sb.length());
        sb.append(root.val+"->");
        recursion(root.right,sb);
        sb.delete(sb.lastIndexOf(root.val+""),sb.length());
        
    }
}
