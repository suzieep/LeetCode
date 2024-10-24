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
// 11:55
class Solution {
    boolean result = true;
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        dfs(root1,root2);
        return result;
    }
    
    private void dfs(TreeNode a,TreeNode b){
        if(a==null&&b==null){
            result = result && true;
        } else if(a!=null&&b!=null &&a.val==b.val){
            Integer aLeft = a.left!=null?a.left.val:null;
            Integer aRight = a.right!=null?a.right.val:null;
            Integer bLeft = b.left!=null?b.left.val:null;
            Integer bRight = b.right!=null?b.right.val:null;
            if(aLeft==bLeft && aRight==bRight){
                dfs(a.left,b.left);
                dfs(a.right,b.right);
            } else if(aLeft==bRight && aRight==bLeft){
                dfs(a.left,b.right);
                dfs(a.right,b.left);
            } else {
                result = result && false;
            }
        } else {
            result = result && false;
        }
    }
}