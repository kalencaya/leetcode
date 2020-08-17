package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

/**
  * 102. Binary Tree Level Order Traversal medium
  */
object BinaryTreeLevelOrderTraversal102ScalaExample {

    def levelOrder(root: TreeNode): List[List[Int]] = {
        val result = new ListBuffer[List[Int]]
        if (root == null) {
            return result.toList
        }
        var current = new ListBuffer[TreeNode]
        var next = new ListBuffer[TreeNode]
        var levelResult = new ListBuffer[Int]
        current += root
        while (!current.isEmpty) {
            val node = current.remove(0)
            if (node != null) {
                if (node.left != null) {
                    next += node.left
                }
                if (node.right != null) {
                    next += node.right
                }
                levelResult += node.value
            }
            if (node == null || current.isEmpty) {
                result += levelResult.toList
                levelResult = new ListBuffer[Int]
                current = next
                next = new ListBuffer[TreeNode]
            }
        }


        result.toList
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(3)
        root.left = new TreeNode(9)
        root.right = new TreeNode(20)
        root.right.left = new TreeNode(15)
        root.right.right = new TreeNode(7)
        val list = levelOrder(root)
        println(list.mkString("[", ", ", "]"))
    }
}
