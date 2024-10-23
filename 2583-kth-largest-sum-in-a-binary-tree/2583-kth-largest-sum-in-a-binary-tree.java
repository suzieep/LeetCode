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
// 11:40
// first submission - 12:08
// success - 12:16
// integer -> long
class Solution {
    Long[] sums = new Long[100001];
    
    public long kthLargestLevelSum(TreeNode root, int k) {
        int currentLevel = 1;
        Arrays.fill(sums, 0L);
        addNode(root,currentLevel);
        Arrays.sort(sums,Collections.reverseOrder());
        return sums[k-1]!=0?sums[k-1]:-1;
    }
    
    private void addNode(TreeNode currentNode, int level){
        sums[level] += currentNode.val;
        if(currentNode.left!=null){
            addNode(currentNode.left,level+1);
        }
        if(currentNode.right!=null){
            addNode(currentNode.right,level+1);
        }
    }
}