# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        return self.bfs(root);
    def bfs(self,root):
        passed = []
        q = deque([root])
        numq = deque([root.val])
        while q:
            node = q.popleft()
            numq.popleft()
            passed.append(node.val)
            if node.left:
                q.append(node.left)   
                numq.append(node.left.val) 
            else:
                q.append(TreeNode(None,None,None))
                numq.append(0)   
            if node.right:
                q.append(node.right)
                numq.append(node.right.val)      
            else:
                q.append(TreeNode(None,None,None))
                numq.append(0)
            if sum(numq)==0:
                break;
            if passed[-1] and None in passed:
                return False

        return not None in passed[:-1]