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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output=new ArrayList<>();
        if(root==null){
            return output;
        }
        HashMap<TreeNode, Integer> position=new HashMap<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        queue.offer(root);
        position.put(root,0);
        while(queue.size()>0){
            TreeNode currNode=queue.poll();
            int currPosition=position.get(currNode);
            min=Math.min(min,currPosition);
            max=Math.max(max,currPosition);
            List<Integer> list=map.getOrDefault(currPosition,new ArrayList<>());
            list.add(currNode.val);
            map.put(currPosition,list);
            if(currNode.left!=null){
                queue.offer(currNode.left);
                position.put(currNode.left,currPosition-1);
            }
            if(currNode.right!=null){
                queue.offer(currNode.right);
                position.put(currNode.right,currPosition+1);
            }
        }
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                output.add(map.get(i));
            }
        }
        return output;
    }
}