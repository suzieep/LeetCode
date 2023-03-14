# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        s = ''
        return self.suming(root,s)
    
    def suming(self,leaf,s):
        s+=str(leaf.val)
        
        if leaf.left and leaf.right:
            return self.suming(leaf.left,s) + self.suming(leaf.right,s)
        elif leaf.left:
            return self.suming(leaf.left,s)
        elif leaf.right:
            return self.suming(leaf.right,s)
        else:
            return int(s)
            