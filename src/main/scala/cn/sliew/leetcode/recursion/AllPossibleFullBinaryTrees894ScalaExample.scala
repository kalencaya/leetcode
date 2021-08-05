package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.tree.{BinaryTreeLevelOrderTraversal102ScalaExample, TreeNode}

import scala.collection.mutable.ListBuffer

/**
  * 894. All Possible Full Binary Trees medium
  */
object AllPossibleFullBinaryTrees894ScalaExample {

    def allPossibleFBT(n: Int): List[TreeNode] = {
        if (n == 1) {
            return List(new TreeNode(0))
        }
        val result = new ListBuffer[TreeNode]()
        for (i <- 1 until n - 1) {
            val lefts = allPossibleFBT(i)
            val rights = allPossibleFBT(n - 1 - i)
            for (left <- lefts; right <- rights) {
                val root = new TreeNode(0)
                root.left = left
                root.right = right
                result += root
            }
        }
        result.toList
    }

    def main(args: Array[String]): Unit = {
        val n = 7
        val nodes = allPossibleFBT(n)
        nodes.map(node => BinaryTreeLevelOrderTraversal102ScalaExample.levelOrder(node)).foreach(println)
    }
}
