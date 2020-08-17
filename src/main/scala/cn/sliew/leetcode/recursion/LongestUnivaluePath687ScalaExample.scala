package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.tree.TreeNode

/**
  * 687.Longest Univalue Path easy
  */
object LongestUnivaluePath687ScalaExample {

    private var ans: Int = 0

    def longestUnivaluePath(root: TreeNode): Int = {
        if (root == null) {
            return 0
        }
        ans = 0
        univaluePath(root)
        ans
    }

    private def univaluePath(root: TreeNode): Int = {
        if (root == null) {
            return 0
        }
        val l = univaluePath(root.left)
        val r = univaluePath(root.right)
        var pl = 0
        var pr = 0
        if (root.left != null && root.value == root.left.value) {
            pl = l + 1
        }
        if (root.right != null && root.value == root.right.value) {
            pr = r + 1
        }

        ans = math.max(ans, pl + pr)
        math.max(pl, pr)
    }


    def main(args: Array[String]): Unit = {
        val root = new TreeNode(5)
        root.left = new TreeNode(4)
        root.right = new TreeNode(5)
        root.left.left = new TreeNode(1)
        root.left.right = new TreeNode(1)
        root.right.right = new TreeNode(5)
        val result = longestUnivaluePath(root)
        println(result)
    }
}
