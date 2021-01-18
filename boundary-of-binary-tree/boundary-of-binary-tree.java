        }
        left(root.left,output);
        leafs(root,output);
        LinkedList<Integer> right=new LinkedList<>();
        right(root.right,right);
        output.addAll(right);
        return output;
    }
    public void left(TreeNode root, ArrayList<Integer> list ){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        list.add(root.val);
        if(root.left!=null)
            left(root.left,list);
        else{
            left(root.right,list);
        }
    }
    public void right(TreeNode root, LinkedList<Integer> list ){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        list.addFirst(root.val);
        if(root.right!=null)
            right(root.right,list);
        else{
            right(root.left,list);
        }
    }
    public void leafs(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        leafs(root.left,list);
        leafs(root.right,list);
    }
}
