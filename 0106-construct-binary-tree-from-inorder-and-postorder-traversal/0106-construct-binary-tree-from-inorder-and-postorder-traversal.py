# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder: 
            return None
        head = postorder[-1]
        idx = inorder.index(head)
        tree = TreeNode(head)
        tree.left = self.buildTree(inorder[:idx], postorder[:idx])
        tree.right = self.buildTree(inorder[idx+1:], postorder[idx:-1])
        return tree