package cn.sliew.leetcode.tree

/**
  * 235. Lowest Common Ancestor of a Binary Search Tree easy
  */
object LowestCommonAncestorofaBinarySearchTree235 {

    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root.value == p.value) {
            return p
        }
        if (root.value == q.value) {
            return q
        }

        if (root.value > p.value && root.value < q.value) {
            return root
        }
        if (root.value < p.value && root.value > q.value) {
            return root
        }

        if (root.value < p.value && root.value < q.value) {
            return lowestCommonAncestor(root.right, p, q)
        }

        if (root.value > p.value && root.value > q.value) {
            return lowestCommonAncestor(root.left, p, q)
        }

        root
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(6)
        root.left = new TreeNode(2)
        root.left.left = new TreeNode(0)
        root.left.right = new TreeNode(4)
        root.left.right.left = new TreeNode(3)
        root.left.right.right = new TreeNode(5)

        root.right = new TreeNode(8)
        root.right.left = new TreeNode(7)
        root.right.right = new TreeNode(9)

        val p = new TreeNode(2)
        val q = new TreeNode(8)
        val result = lowestCommonAncestor(root, p, q)
        println(result.value)
    }

}
