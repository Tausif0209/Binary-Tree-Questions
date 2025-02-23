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
    int i=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructBT(preorder,postorder,0,preorder.length-1);
    }
    TreeNode constructBT(int[] preorder,int[] postorder,int start,int end)
    {
        if(start>end) return null;
        TreeNode node=new TreeNode(preorder[i++]);
        if(i==preorder.length){
            node.left=null;
            node.right=null;
            return node;
        }
        int index=find(postorder,preorder[i],start,end);
        if(index==-1){
            node.left=null;
            node.right=null;
            return node;
        }
        node.left=constructBT(preorder,postorder,start,index);
        node.right=constructBT(preorder,postorder,index+1,end-1);
        return node;
    }
    int find(int[] arr,int target,int start,int end){
        for(int i=start;i<=end;i++)
        {
            if(arr[i]==target) return i;
        }
        return -1;
    }
}