package cn.sliew.leetcode.binarysearch

import cn.sliew.leetcode.tree.TreeNode

/**
  * 222. Count Complete Tree Nodes medium
  */
object CountCompleteTreeNodes222ScalaExample {

    def countNodes(root: TreeNode): Int = {
        if (root == null) {
            return 0
        }
        var count = 1
        if (root.left != null) {
            count += countNodes(root.left)
        }
        if (root.right != null) {
            count += countNodes(root.right)
        }
        count
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        root.left.left = new TreeNode(4)
        root.left.right = new TreeNode(5)
        root.right.left = new TreeNode(6)
        val result = countNodes(root)
        println(result)
    }

}
