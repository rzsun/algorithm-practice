# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        map = {}
        self.traverse(root, map)
        res = []
        i = min(map.keys())
        while i in map.keys():
            res.append(map[i])
            i += 1
        return res

    def traverse(self, root: Optional[TreeNode], map: dict[int, list[int]]):
        if root == None:
            return
        cur = [(root, 0)]
        next = []
        while len(cur) > 0:
            for (node, col) in cur:
                if col not in map.keys():
                    map[col] = []
                map[col].append(node.val)
                if node.left != None:
                    next.append((node.left, col-1))
                if node.right != None:
                    next.append((node.right, col+1))
            cur = next
            next = []