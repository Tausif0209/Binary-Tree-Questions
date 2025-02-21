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
class FindElements {
    // TreeNode node;
    HashSet<Integer> set=new HashSet<>();
    public FindElements(TreeNode root) {
        // node=root;
        recoverTree(root,0);
    }
    
    public boolean find(int target) {
    //    return helper(node,target,0);
    return set.contains(target);
    }
    // private boolean helper(TreeNode node,int target,int x)
    // {
    //     if(node==null || x>target) return false;
    //     return (x==target)|| helper(node.left,target,2*x+1) || helper(node.right,target,2*x+2);
    // }
    private void recoverTree(TreeNode root,int val)
    {
        if(root==null) return ;
        set.add(val);
        recoverTree(root.left,val*2+1);
        recoverTree(root.right,val*2+2);
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */