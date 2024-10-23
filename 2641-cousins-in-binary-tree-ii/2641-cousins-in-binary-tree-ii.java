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

// 12:00 - 12:31
class Solution {
    int[] sumOfLevel = new int[100001];

    public TreeNode replaceValueInTree(TreeNode root) {
        addSum(root,1);
        return getCousinsSum(root,1,root.val);
    }

    private void addSum(TreeNode currentNode, int level){
        sumOfLevel[level] += currentNode.val;
        if(currentNode.left!=null){
            addSum(currentNode.left,level+1);
        }
        if(currentNode.right!=null){
            addSum(currentNode.right,level+1);
        }
    }
    
    private TreeNode getCousinsSum(TreeNode currentNode, int level, int sisters){
        TreeNode result = new TreeNode();
        result.val = sumOfLevel[level]-sisters;
        
        if(currentNode.left!=null && currentNode.right!=null){
            sisters = currentNode.left.val + currentNode.right.val;
        } else if(currentNode.left!=null){
            sisters = currentNode.left.val;
        } else if(currentNode.right!=null){
            sisters = currentNode.right.val;
        }
        
        if(currentNode.left!=null){
            result.left = getCousinsSum(currentNode.left,level+1,sisters);}
        if(currentNode.right!=null){
            result.right = getCousinsSum(currentNode.right,level+1,sisters);
        }
        return result;
    }
    
    
}