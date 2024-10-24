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
// start -11:55
// first submission - 12:15
// success - 12:17
class Solution {
    boolean result = true;
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }
    
    private boolean dfs(TreeNode a,TreeNode b){
        if(a==null&&b==null){
            return true;
        } else if(a!=null&&b!=null &&a.val==b.val){
            return (dfs(a.left,b.left) && dfs(a.right,b.right)) || (dfs(a.left,b.right) && dfs(a.right,b.left));
        } else {
            return false;
        }
    }
}